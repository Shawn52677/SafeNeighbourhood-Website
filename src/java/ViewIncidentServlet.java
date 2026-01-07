import bean.ViewIncidentBean;
import dao.ViewIncidentDao;
import model.Incident;
import model.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ViewIncidentServlet")
public class ViewIncidentServlet extends HttpServlet {

    // Process incident viewing and status updating
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String reportedBy = request.getParameter("reportedBy");
        String status = request.getParameter("status");
        
        ViewIncidentBean viewIncidentBean = new ViewIncidentBean(title, description ,location, reportedBy, status);
        ViewIncidentDao viewIncidentDao = new ViewIncidentDao();
        
        String result = viewIncidentDao.viewIncident(viewIncidentBean);
        
        // Handle status update
        if ("updateStatus".equals(action)) {
            String incidentId = request.getParameter("id");
            String newStatus = request.getParameter("status");

            try (Connection con = DBConnection.getConnection()) {
                String query = "UPDATE incident SET status = ? WHERE id = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, newStatus);
                    pst.setInt(2, Integer.parseInt(incidentId));
                    pst.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Error updating incident status.");
            }
        }

        // Display all incidents
        List<Incident> incidentList = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM incident";
            try (PreparedStatement pst = con.prepareStatement(query);
                 ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    Incident incident = new Incident();
                    incident.setId(rs.getInt("id"));
                    incident.setTitle(rs.getString("title"));
                    incident.setDescription(rs.getString("description"));
                    incident.setLocation(rs.getString("location"));
                    incident.setReportedBy(rs.getString("reportedBy"));
                    incident.setStatus(rs.getString("status"));
                    incidentList.add(incident);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }

        request.setAttribute("incidentList", incidentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_incident.jsp");
        dispatcher.forward(request, response);
    }
}
