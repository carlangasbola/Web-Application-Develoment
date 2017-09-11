 package paquete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet2 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  @Override
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    
    HttpSession session = request.getSession();
    
    String parametro1 = (String)session.getAttribute("parametro1");
    String parametro2 = (String)session.getAttribute("parametro2");
    
    
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Servlet1</title></head>");
    out.println("<body>");
    out.println("<p>    Hola Hola  </p>" + parametro1 + " " + parametro2);
    
    out.println("</body></html>");
  }
}