import dao.ViewUserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ViewUserServlet")
public class ViewUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewUserDao viewUserDao = new ViewUserDao();

        try {
            // Fetch the list of users from the database
            List<User> userList = viewUserDao.getAllUsers();
            // Set the user list as a request attribute
            request.setAttribute("userList", userList);

            // Forward to the JSP page for display
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_user.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Unable to fetch users: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
