

import model.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.sql.*;

@WebServlet("/UserDashboardServlet")
public class UserDashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM incident";
            try (PreparedStatement pst = con.prepareStatement(query); 
                 ResultSet rs = pst.executeQuery()) {

                request.setAttribute("incidentResultSet", rs);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("user_dashboard.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
        }
    }
}
