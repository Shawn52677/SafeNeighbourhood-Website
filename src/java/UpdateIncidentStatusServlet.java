
import bean.UpdateIncidentBean;
import model.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

public class UpdateIncidentStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int incidentId = Integer.parseInt(request.getParameter("id"));
        String newStatus = request.getParameter("status");
        
        UpdateIncidentBean updateIncidentBean = new UpdateIncidentBean(incidentId , newStatus);

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "UPDATE incident SET status = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newStatus);
            stmt.setInt(2, incidentId);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Status updated successfully, redirect back to the view incident page
                response.sendRedirect("ViewIncidentServlet");
            } else {
                // Error in updating, display error message
                request.setAttribute("error", "Failed to update incident status.");
                request.getRequestDispatcher("view_incident.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("view_incident.jsp").forward(request, response);
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
