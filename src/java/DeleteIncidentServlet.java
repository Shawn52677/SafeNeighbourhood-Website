import dao.DeleteIncidentDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteIncidentServlet")
public class DeleteIncidentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user ID from the form
        String userId = request.getParameter("id");

        HttpSession session = request.getSession(); // Get the session to store messages

        try {
            int id = Integer.parseInt(userId); // Convert the user ID to an integer
            DeleteIncidentDao incidentDAO = new DeleteIncidentDao(); // Create an instance of UserDAO
            boolean isDeleted = incidentDAO.deleteIncidentById(id); // Call DAO method to delete user

            // Set session attributes based on the outcome
            if (isDeleted) {
                session.setAttribute("message", "Incident deleted successfully.");
                session.setAttribute("messageType", "success");
            } else {
                session.setAttribute("message", "Failed to delete incident. Incident not found.");
                session.setAttribute("messageType", "error");
            }
        } catch (NumberFormatException e) {
            // Handle invalid user ID format
            session.setAttribute("message", "Invalid incident ID format.");
            session.setAttribute("messageType", "error");
        }

        // Redirect back to view_user.jsp
        response.sendRedirect("view_incident.jsp");
    }
}