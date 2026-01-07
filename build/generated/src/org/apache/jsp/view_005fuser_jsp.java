package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import model.DBConnection;

public final class view_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">\n");
      out.write("    <title>View Users</title>\n");
      out.write("    <style>\n");
      out.write("        .message {\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            border: 1px solid;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .message.success {\n");
      out.write("            color: green;\n");
      out.write("            background-color: #e9f9e9;\n");
      out.write("            border-color: green;\n");
      out.write("        }\n");
      out.write("        .message.error {\n");
      out.write("            color: red;\n");
      out.write("            background-color: #f9e9e9;\n");
      out.write("            border-color: red;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background: rgba(255, 255, 255, 0.2);\n");
      out.write("        }\n");
      out.write("        input, select {\n");
      out.write("            width: 90%;\n");
      out.write("            padding: 6px;\n");
      out.write("            margin: 4px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("        .input-container {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        .input-container input,\n");
      out.write("        .input-container select {\n");
      out.write("            flex: 1;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            padding: 6px 12px;\n");
      out.write("            margin: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        body, html {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            height: 100%;\n");
      out.write("            font-family: 'Arial', sans-serif;\n");
      out.write("            background: linear-gradient(135deg, #6a11cb, #2575fc);\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            color: #fff;\n");
      out.write("            flex-direction: column;\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            background: rgba(255, 255, 255, 0.1);\n");
      out.write("            padding: 2rem;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);\n");
      out.write("            width: 90%;\n");
      out.write("            max-width: 600px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            margin-bottom: 1.5rem;\n");
      out.write("            font-size: 2rem;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            margin: 0.5rem 0 0.25rem;\n");
      out.write("            font-size: 1rem;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 0.8rem;\n");
      out.write("            margin-bottom: 1rem;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            outline: none;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            background: rgba(255, 255, 255, 0.2);\n");
      out.write("            color: #fff;\n");
      out.write("            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input::placeholder {\n");
      out.write("            color: rgba(255, 255, 255, 0.7);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button {\n");
      out.write("            background: #6a11cb;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 0.8rem 2rem;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        button:hover {\n");
      out.write("            background: #2575fc;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        p {\n");
      out.write("            margin-top: 1rem;\n");
      out.write("            font-size: 0.9rem;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a {\n");
      out.write("            color: #fff;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        /* Buttons Styling */\n");
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
      out.write("    .report-button {\n");
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
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
 
        // Check if user is logged in and is an admin
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Fetching the message from session if any (like success or error messages)
        String message = (String) session.getAttribute("message");
        String messageType = (String) session.getAttribute("messageType");

        if (message != null) {
    
      out.write("\n");
      out.write("    <div class=\"message ");
      out.print( messageType );
      out.write("\">\n");
      out.write("        ");
      out.print( message );
      out.write("\n");
      out.write("    </div>\n");
      out.write("    ");

            session.removeAttribute("message");
            session.removeAttribute("messageType");
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <h1>List of Users</h1>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Username</th>\n");
      out.write("            <th>Password</th>\n");
      out.write("            <th>Role</th>\n");
      out.write("            <th>Action</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnection.getConnection();
                String sql = "SELECT * FROM users";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String userRole = rs.getString("role");
        
      out.write("\n");
      out.write("        <tr id=\"user_");
      out.print( id );
      out.write("\">\n");
      out.write("            <td>");
      out.print( id );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <div class=\"input-container\">\n");
      out.write("                    <input type=\"text\" id=\"username_");
      out.print( id );
      out.write("\" value=\"");
      out.print( username );
      out.write("\" disabled />\n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <div class=\"input-container\">\n");
      out.write("                    <input type=\"password\" id=\"password_");
      out.print( id );
      out.write("\" value=\"");
      out.print( password );
      out.write("\" disabled />\n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <div class=\"input-container\">\n");
      out.write("                    <select id=\"role_");
      out.print( id );
      out.write("\" disabled>\n");
      out.write("                        <option value=\"admin\" ");
      out.print( userRole.equals("admin") ? "selected" : "" );
      out.write(">Admin</option>\n");
      out.write("                        <option value=\"user\" ");
      out.print( userRole.equals("user") ? "selected" : "" );
      out.write(">User</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <button type=\"button\" id=\"editBtn_");
      out.print( id );
      out.write("\" onclick=\"enableEdit(");
      out.print( id );
      out.write(")\">Edit</button>\n");
      out.write("                <button type=\"button\" id=\"saveBtn_");
      out.print( id );
      out.write("\" onclick=\"updateUser(");
      out.print( id );
      out.write(")\" style=\"display:none;\">Save</button>\n");
      out.write("                <button type=\"button\" onclick=\"deleteUser(");
      out.print( id );
      out.write(")\">Delete</button>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            } catch (Exception e) {
                e.printStackTrace();
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"5\">Error occurred while fetching data</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <a href=\"admin_dashboard.jsp\" class=\"button report-button\">Back</a>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Enable editing the user details\n");
      out.write("        function enableEdit(id) {\n");
      out.write("            document.getElementById(\"username_\" + id).disabled = false;\n");
      out.write("            document.getElementById(\"password_\" + id).disabled = false;\n");
      out.write("            document.getElementById(\"role_\" + id).disabled = false;\n");
      out.write("            document.getElementById(\"editBtn_\" + id).style.display = 'none';\n");
      out.write("            document.getElementById(\"saveBtn_\" + id).style.display = 'inline';\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Update user after editing\n");
      out.write("        function updateUser(id) {\n");
      out.write("            var username = document.getElementById(\"username_\" + id).value;\n");
      out.write("            var password = document.getElementById(\"password_\" + id).value;\n");
      out.write("            var role = document.getElementById(\"role_\" + id).value;\n");
      out.write("\n");
      out.write("            var xhr = new XMLHttpRequest();\n");
      out.write("            xhr.open('POST', 'UpdateUserServlet', true);\n");
      out.write("            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("            xhr.onload = function() {\n");
      out.write("                if (xhr.status == 200) {\n");
      out.write("                    alert(\"User updated successfully\");\n");
      out.write("                    location.reload(); // Reload the page after update\n");
      out.write("                } else {\n");
      out.write("                    alert(\"Error updating user\");\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            xhr.send('id=' + id + '&username=' + username + '&password=' + password + '&role=' + role);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        // Delete user\n");
      out.write("        function deleteUser(id) {\n");
      out.write("            if (confirm('Are you sure you want to delete this user?')) {\n");
      out.write("                var xhr = new XMLHttpRequest();\n");
      out.write("                xhr.open('POST', 'DeleteUserServlet', true);\n");
      out.write("                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n");
      out.write("                xhr.onload = function() {\n");
      out.write("                    if (xhr.status == 200) {\n");
      out.write("                        document.getElementById(\"user_\" + id).remove(); // Remove the row after deletion\n");
      out.write("                    } else {\n");
      out.write("                        alert(\"Error deleting user\");\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xhr.send('id=' + id);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
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
