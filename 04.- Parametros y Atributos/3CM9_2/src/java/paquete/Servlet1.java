package paquete;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet1 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  @Override
  
  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    
    // Recuperamos los parametros de index.html
    String parametro1 = request.getParameter("parametro1");
    String parametro2 = request.getParameter("parametro2");
    
    /*  Con HttpSesssion guardamos a nivel de sesion las variables
        la definición es Clave-Objeto y seran recuperadas en el Servlet2
    */
    HttpSession session = request.getSession();
    session.setAttribute("atributo1", parametro1);
    session.setAttribute("atributo2", parametro2);
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Servlet1</title></head>");
    out.println("<body>");
    out.println("<p>    Hola Hola  </p>");
    
    out.println("</body></html>");
  }
 
}