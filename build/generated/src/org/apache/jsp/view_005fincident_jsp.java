package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DBConnection;
import java.sql.*;

public final class view_005fincident_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>View Incidents</title>\n");
      out.write("    <style>\n");
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
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Styling for the action buttons */\n");
      out.write("        .action-buttons {\n");
      out.write("            display: flex;\n");
      out.write("            gap: 10px; /* Space between buttons */\n");
      out.write("            justify-content: center; /* Center the buttons */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .action-buttons button {\n");
      out.write("            padding: 8px 16px;\n");
      out.write("            font-size: 14px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .update-btn {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .delete-btn {\n");
      out.write("            background-color: #f44336;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .update-btn:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .delete-btn:hover {\n");
      out.write("            background-color: #e53935;\n");
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
      out.write("            width: 90%;\n");
      out.write("            max-width: 900px;\n");
      out.write("            background: rgba(255, 255, 255, 0.1);\n");
      out.write("            padding: 2rem;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.2);\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            font-size: 2.5rem;\n");
      out.write("            margin-bottom: 1.5rem;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            margin-top: 1.5rem;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table th, table td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("            border: 1px solid rgba(255, 255, 255, 0.2);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table th {\n");
      out.write("            background: rgba(255, 255, 255, 0.2);\n");
      out.write("            color: #fff;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table tbody tr:hover {\n");
      out.write("            background: rgba(255, 255, 255, 0.2);\n");
      out.write("            cursor: pointer;\n");
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
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");

        // Check if user is logged in
        String role = (String) session.getAttribute("role"); // Role: "admin" or "user"
        if (role == null) {
            // Redirect to login if no session exists
            response.sendRedirect("login.jsp");
            return;
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <h1>List of Incidents</h1>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Title</th>\n");
      out.write("            <th>Description</th>\n");
      out.write("            <th>Location</th>\n");
      out.write("            <th>Reported By</th>\n");
      out.write("            <th>Status</th>\n");
      out.write("            <th>Actions</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = DBConnection.getConnection();
                String sql = "SELECT * FROM incident";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String location = rs.getString("location");
                    String reportedBy = rs.getString("reported_by");
                    String status = rs.getString("status");
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( id );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( title );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( description );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( location );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( reportedBy );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( status );
      out.write("</td>\n");
      out.write("\n");
      out.write("            ");

                if ("admin".equals(role)) {
            
      out.write("\n");
      out.write("            <td>\n");
      out.write("                <div class=\"action-buttons\">\n");
      out.write("                    <!-- Form to update status -->\n");
      out.write("                    <form action=\"UpdateIncidentStatusServlet\" method=\"POST\">\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\n");
      out.write("                        <select name=\"status\">\n");
      out.write("                            <option value=\"reported\" ");
      out.print( status.equals("reported") ? "selected" : "" );
      out.write(">Reported</option>\n");
      out.write("                            <option value=\"in progress\" ");
      out.print( status.equals("in progress") ? "selected" : "" );
      out.write(">In Progress</option>\n");
      out.write("                            <option value=\"resolved\" ");
      out.print( status.equals("resolved") ? "selected" : "" );
      out.write(">Resolved</option>\n");
      out.write("                        </select>\n");
      out.write("                        <button class=\"update-btn\" type=\"submit\">Update Status</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <!-- Form for Deleting an incident -->\n");
      out.write("                    <form action=\"DeleteIncidentServlet\" method=\"POST\" onsubmit=\"return confirm('Are you sure you want to delete this incident?');\">\n");
      out.write("                        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\" />\n");
      out.write("                        <button class=\"delete-btn\" type=\"submit\">Delete</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </td>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            } catch (Exception e) {
                e.printStackTrace();
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"7\">An error occurred while fetching data.</td>\n");
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
      out.write("    ");

        // Role-specific navigation
        if ("admin".equals(role)) {
    
      out.write("\n");
      out.write("        <a href=\"admin_dashboard.jsp\" class=\"button report-button\">Back</a>\n");
      out.write("    ");

        } else if ("user".equals(role)) {
    
      out.write("\n");
      out.write("        <a href=\"user_dashboard.jsp\" class=\"button report-button\">Back</a>\n");
      out.write("    ");

        }
    
      out.write("\n");
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
