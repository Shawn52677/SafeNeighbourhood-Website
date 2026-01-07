package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">\n");
      out.write("    <title>Register</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-image: url('https://source.unsplash.com/featured/?technology,abstract');\n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("            background: linear-gradient(135deg, #6a11cb, #2575fc);\n");
      out.write("            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            height: 100vh;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            background-color: rgba(255, 255, 255, 0.95);\n");
      out.write("            padding: 40px;\n");
      out.write("            width: 90%;\n");
      out.write("            max-width: 450px;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        form {\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            text-align: left;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"],\n");
      out.write("        input[type=\"password\"],\n");
      out.write("        select {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-weight: bold;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-link {\n");
      out.write("            margin-top: 15px;\n");
      out.write("            font-size: 14px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-link a {\n");
      out.write("            color: #007bff;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-link a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Create an Account</h1>\n");
      out.write("        <form action=\"RegisterServlet\" method=\"post\">\n");
      out.write("            <label for=\"username\">Username:</label>\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"Enter your username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"Enter your password\" required>\n");
      out.write("\n");
      out.write("            <label for=\"role\">Select Role:</label>\n");
      out.write("            <select name=\"role\" required>\n");
      out.write("                <option value=\"\" disabled selected>Select your role</option>\n");
      out.write("                <option value=\"user\">User</option>\n");
      out.write("                <option value=\"admin\">Admin</option>\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Register\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <p class=\"back-link\">Already have an account? <a href=\"login.jsp\">Login here</a></p>\n");
      out.write("    </div>\n");
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
