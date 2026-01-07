import model.DBConnection;
import bean.LoginBean;
import dao.LoginDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user input
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Username and password cannot be empty.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Populate the LoginBean
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        // Authenticate user
        LoginDao loginDao = new LoginDao();
        String userValidate = loginDao.authenticateUser(loginBean);

        HttpSession session = request.getSession();

        if (userValidate.equals("SUCCESS")) {
            try (Connection con = DBConnection.getConnection()) {
                String query = "SELECT role FROM users WHERE username = ? AND password = ?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, username);
                    pst.setString(2, password);

                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            String role = rs.getString("role");

                            // Set session attributes
                            session.setAttribute("username", username);
                            session.setAttribute("role", role);

                            // Redirect based on user role
                            if ("admin".equals(role)) {
                                response.sendRedirect("admin_dashboard.jsp");
                            } else {
                                response.sendRedirect("user_dashboard.jsp");
                            }
                        } else {
                            request.setAttribute("error", "Invalid username or password.");
                            request.getRequestDispatcher("login.jsp").forward(request, response);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "Database error: " + e.getMessage());
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            // Invalid credentials
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
