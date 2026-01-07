import bean.UpdateUserBean;
import model.DBConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try {
            // Parse and validate inputs
            int id = Integer.parseInt(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            if (username == null || username.isEmpty() || password == null || password.isEmpty() || role == null || role.isEmpty()) {
                out.write("Invalid input");
                return;
            }

            // Populate UpdateUserBean
            UpdateUserBean updateUserBean = new UpdateUserBean(id, username, password, role);

            // Update user in the database
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, updateUserBean.getUsername());
                    pstmt.setString(2, updateUserBean.getPassword());
                    pstmt.setString(3, updateUserBean.getRole());
                    pstmt.setInt(4, id);

                    int result = pstmt.executeUpdate();

                    if (result > 0) {
                        out.write("success");
                    } else {
                        out.write("failure");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.write("error");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            out.write("Invalid ID format");
        }
    }
}
