import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Servlet1 extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    
    
    // Clase en java que nos permite guardar parametros del lado del cliente
    Cookie galleta2 = new Cookie("id2","12");
    Cookie galleta3 = new Cookie("id3","13");
    
    // Definimos el tiempo de vida de la galleta (milisegundos) en este caso
    /* Son 365 dias por 24 hora por 60 minutos por 60 segundos * 1000 milisegundos
       SI NO SE ESTABLECEN SE DESTRUYEN AL CERRAR LA PESTAÑA
    */
    galleta2.setMaxAge(365*24*60*60*1000);
    
    // Crea una persistencia de datos y se guarda en un archivo de texto
    response.addCookie(galleta2);
    response.addCookie(galleta3);
    
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Servlet1</title></head>");
    out.println("<body>");
    out.println("<p> CREANDO LAS GALLETAS </p>");
    out.println("</body></html>");
  }
 
  
}