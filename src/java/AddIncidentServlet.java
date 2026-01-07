import bean.AddIncidentBean;
import dao.AddIncidentDao;
import model.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddIncidentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the form
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        String reportedBy = request.getParameter("reportedBy");
        
        AddIncidentBean addIncidentBean = new AddIncidentBean(title, description ,location, reportedBy);
        AddIncidentDao addIncidentDao = new AddIncidentDao();
        
        String result = addIncidentDao.addIncident(addIncidentBean);

        // Check for null or empty values
        if (title == null || description == null || location == null || reportedBy == null ||
            title.trim().isEmpty() || description.trim().isEmpty() || location.trim().isEmpty() || reportedBy.trim().isEmpty()) {
            request.setAttribute("message", "All fields are required.");
            request.getRequestDispatcher("add_incident.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // Insert the incident into the database
            String sql = "INSERT INTO incident (title, description, location, reported_by, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, location);
            stmt.setString(4, reportedBy);
            stmt.setString(5, "Pending");

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                request.setAttribute("message", "Incident reported successfully.");
                request.getRequestDispatcher("user_dashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Failed to report incident.");
                request.getRequestDispatcher("add_incident.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while processing your request.");
            request.getRequestDispatcher("add_incident.jsp").forward(request, response);
        }
    }
}