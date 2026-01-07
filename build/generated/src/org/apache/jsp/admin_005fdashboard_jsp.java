package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Incident;
import model.DBConnection;
import java.sql.*;

public final class admin_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">\n");
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        .notification {\n");
      out.write("            padding: 10px;\n");
      out.write("            background-color: #f1f8ff;\n");
      out.write("            border: 1px solid #c1d8e5;\n");
      out.write("            color: #007acc;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            width: 80%;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto;\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("        .notification h2 {\n");
      out.write("            font-size: 16px;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        .notification p {\n");
      out.write("            margin: 5px 0;\n");
      out.write("        }\n");
      out.write("        .notification button {\n");
      out.write("            background-color: #007acc;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            padding: 5px 10px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 14px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .notification button:hover {\n");
      out.write("            background-color: #005fa3;\n");
      out.write("        }\n");
      out.write("        .error {\n");
      out.write("            color: red;\n");
      out.write("        }\n");
      out.write("     body, html {\n");
      out.write("        margin: 0;\n");
      out.write("        padding: 0;\n");
      out.write("        height: 100%;\n");
      out.write("        font-family: 'Arial', sans-serif;\n");
      out.write("        background: linear-gradient(135deg, #6a11cb, #2575fc);\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: center;\n");
      out.write("        align-items: center;\n");
      out.write("        color: #ffffff;\n");
      out.write("        flex-direction: column;\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Main Container Styling */\n");
      out.write("    .container {\n");
      out.write("        width: 90%;\n");
      out.write("        max-width: 800px;\n");
      out.write("        background: rgba(255, 255, 255, 0.1);\n");
      out.write("        padding: 2rem;\n");
      out.write("        border-radius: 15px;\n");
      out.write("        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);\n");
      out.write("        text-align: center;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    h1 {\n");
      out.write("        font-size: 2.5rem;\n");
      out.write("        margin-bottom: 1.5rem;\n");
      out.write("        color: #ffffff;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Buttons Styling */\n");
      out.write("    .button {\n");
      out.write("        text-decoration: none;\n");
      out.write("        color: white;\n");
      out.write("        font-weight: bold;\n");
      out.write("        padding: 15px 30px;\n");
      out.write("        border: none;\n");
      out.write("        border-radius: 25px;\n");
      out.write("        display: inline-block;\n");
      out.write("        font-size: 16px;\n");
      out.write("        margin: 10px;\n");
      out.write("        transition: transform 0.3s ease, box-shadow 0.3s ease;\n");
      out.write("        cursor: pointer;\n");
      out.write("        position: relative;\n");
      out.write("        overflow: hidden;\n");
      out.write("        width: 50px; /* Ensures a consistent button size */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Gradient Buttons */\n");
      out.write("    .report-button {\n");
      out.write("        background: linear-gradient(135deg, #ff7eb3, #ff758c);\n");
      out.write("        box-shadow: 0 5px 15px rgba(255, 117, 140, 0.4);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .view-button {\n");
      out.write("        background: linear-gradient(135deg, #42e695, #3bb2b8);\n");
      out.write("        box-shadow: 0 5px 15px rgba(59, 178, 184, 0.4);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .logout-button {\n");
      out.write("        background: linear-gradient(135deg, #ff4b1f, #ff9068);\n");
      out.write("        box-shadow: 0 5px 15px rgba(255, 144, 104, 0.4);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Hover Effects */\n");
      out.write("    .button:hover {\n");
      out.write("        transform: translateY(-3px);\n");
      out.write("        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Ripple Effect */\n");
      out.write("    .button:active::after {\n");
      out.write("        content: '';\n");
      out.write("        position: absolute;\n");
      out.write("        top: 50%;\n");
      out.write("        left: 50%;\n");
      out.write("        width: 200%;\n");
      out.write("        height: 200%;\n");
      out.write("        background: rgba(255, 255, 255, 0.3);\n");
      out.write("        border-radius: 50%;\n");
      out.write("        transform: translate(-50%, -50%) scale(0);\n");
      out.write("        animation: ripple 0.6s ease-out;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    @keyframes ripple {\n");
      out.write("        to {\n");
      out.write("            transform: translate(-50%, -50%) scale(1);\n");
      out.write("            opacity: 0;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav ul {\n");
      out.write("        list-style: none;\n");
      out.write("        padding: 0;\n");
      out.write("        margin: 1.5rem 0;\n");
      out.write("        display: flex;\n");
      out.write("        justify-content: center;\n");
      out.write("        flex-wrap: wrap; /* Allow buttons to wrap on smaller screens */\n");
      out.write("        gap: 1rem; /* Adds spacing between items */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    nav ul li {\n");
      out.write("        margin: 0.5rem; /* Adds vertical spacing for a cleaner layout */\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    /* Statistics Section */\n");
      out.write("    .stats {\n");
      out.write("        margin-top: 2rem;\n");
      out.write("        text-align: left;\n");
      out.write("        font-size: 1.2rem;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .stats span {\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("    <script>\n");
      out.write("        function markAsRead() {\n");
      out.write("            // Hide the notification\n");
      out.write("            var notification = document.getElementById(\"notification\");\n");
      out.write("            notification.style.display = \"none\";\n");
      out.write("\n");
      out.write("            // Set session attribute using AJAX to indicate that the notification has been marked as read\n");
      out.write("            var xhr = new XMLHttpRequest();\n");
      out.write("            xhr.open(\"POST\", \"markAsReadServlet\", true);\n");
      out.write("            xhr.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n");
      out.write("            xhr.send(\"action=markAsRead\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Welcome, Admin: ");
      out.print( session.getAttribute("username") );
      out.write("</h1>\n");
      out.write("\n");
      out.write("    ");

        // Check if user is logged in
        String role = (String) session.getAttribute("role"); // Role: "admin" or "user"
        if (role == null) {
            // Redirect to login if no session exists
            response.sendRedirect("login.jsp");
            return;
        }

        // Check if the user has already marked the notification as read
        Boolean isNotificationRead = (Boolean) session.getAttribute("isNotificationRead");
        if (isNotificationRead != null && isNotificationRead) {
            // If notification is marked as read, do not display it
            response.sendRedirect("admin_dashboard.jsp");
            return;
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <h1>Latest Incident</h1>\n");
      out.write("    \n");
      out.write("    ");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            // Correct SQL query for Apache Derby
            String sql = "SELECT * FROM incident WHERE mark = FALSE ORDER BY id DESC FETCH FIRST 1 ROWS ONLY";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String reportedBy = rs.getString("reported_by");
                String status = rs.getString("status");
        
      out.write("\n");
      out.write("        <div id=\"notification\" class=\"notification\">\n");
      out.write("    <p><strong>ID:</strong> ");
      out.print( rs.getInt("id") );
      out.write("</p>\n");
      out.write("    <p><strong>Title:</strong> ");
      out.print( rs.getString("title") );
      out.write("</p>\n");
      out.write("    <p><strong>Description:</strong> ");
      out.print( rs.getString("description") );
      out.write("</p>\n");
      out.write("    <p><strong>Location:</strong> ");
      out.print( rs.getString("location") );
      out.write("</p>\n");
      out.write("    <p><strong>Reported By:</strong> ");
      out.print( rs.getString("reported_by") );
      out.write("</p>\n");
      out.write("    <form action=\"MarkAsReadServlet\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( rs.getInt("id") );
      out.write("\">\n");
      out.write("        <button type=\"submit\">Mark as Read</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("        ");

            } else {
        
      out.write("\n");
      out.write("        <div class=\"notification error\">\n");
      out.write("            No incident reported yet.\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        } catch (SQLException e) {
            out.println("<div class='notification error'>An error occurred while fetching data: " + e.getMessage() + "</div>");
            e.printStackTrace();
        } catch (Exception e) {
            out.println("<div class='notification error'>Unexpected error: " + e.getMessage() + "</div>");
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("        <!-- Buttons -->\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h1>Admin Actions</h1>\n");
      out.write("    <nav>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"view_incident.jsp\" class=\"button report-button\">View Incident</a></li>\n");
      out.write("            <li><a  href=\"view_user.jsp\" class=\"button view-button\">View Users</a></li>\n");
      out.write("            <li><a href=\"LogoutServlet\" class=\"button logout-button\">Logout</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
