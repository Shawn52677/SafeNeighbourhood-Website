import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the current session
        HttpSession session = request.getSession(false); // Avoid creating a new session if one doesn't exist
        if (session != null) {
            // Invalidate the session to log the user out
            session.invalidate();
            System.out.println("User logged out successfully.");
        }
        // Redirect to the login page
        response.sendRedirect("login.jsp");

    }
}