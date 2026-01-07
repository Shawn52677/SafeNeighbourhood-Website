package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fincident_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\">\n");
      out.write("    <title>Add Incident</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Report an Incident</h1>\n");
      out.write("    <form action=\"AddIncidentServlet\" method=\"post\">\n");
      out.write("        <label for=\"title\">Title:</label>\n");
      out.write("        <input type=\"text\" name=\"title\" required><br>\n");
      out.write("        <label for=\"description\">Description:</label>\n");
      out.write("        <textarea name=\"description\" required></textarea><br>\n");
      out.write("        <label for=\"location\">Location:</label>\n");
      out.write("        <input type=\"text\" id=\"location\" name=\"location\" required>\n");
      out.write("        <label for=\"reportedBy\">Reported By:</label>\n");
      out.write("        <input type=\"text\" id=\"reportedBy\" name=\"reportedBy\" required><br>\n");
      out.write("        <input type=\"submit\" value=\"Submit\">\n");
      out.write("    </form>\n");
      out.write("    <style>\n");
      out.write("    body, html {\n");
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
      out.write("            max-width: 600px;\n");
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
      out.write("        form {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            gap: 1rem;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            text-align: left;\n");
      out.write("            font-size: 1rem;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input, select, textarea, button {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 0.8rem;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            background: rgba(255, 255, 255, 0.2);\n");
      out.write("            color: #fff;\n");
      out.write("            box-shadow: inset 0 2px 4px rgba(0, 0, 0, 0.1);\n");
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
      out.write("        </style>\n");
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
