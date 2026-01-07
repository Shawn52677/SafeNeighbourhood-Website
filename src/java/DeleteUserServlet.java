import dao.DeleteUserDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the user ID from the form
        String userId = request.getParameter("id");

        HttpSession session = request.getSession(); // Get the session to store messages

        try {
            int id = Integer.parseInt(userId); // Convert the user ID to an integer
            DeleteUserDao userDAO = new DeleteUserDao(); // Create an instance of UserDAO
            boolean isDeleted = userDAO.deleteUserById(id); // Call DAO method to delete user

            // Set session attributes based on the outcome
            if (isDeleted) {
                session.setAttribute("message", "User deleted successfully.");
                session.setAttribute("messageType", "success");
            } else {
                session.setAttribute("message", "Failed to delete user. User not found.");
                session.setAttribute("messageType", "error");
            }
        } catch (NumberFormatException e) {
            // Handle invalid user ID format
            session.setAttribute("message", "Invalid user ID format.");
            session.setAttribute("messageType", "error");
        }

        // Redirect back to view_user.jsp
        response.sendRedirect("view_user.jsp");
    }
}