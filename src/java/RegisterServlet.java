import bean.RegisterBean;
import dao.RegisterDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        RegisterBean registerBean = new RegisterBean(username, password,role);
        RegisterDao registerDao = new RegisterDao();
        
        String result = registerDao.registerUser(registerBean);
        
         if ("Data entered successfully".equals(result)) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}