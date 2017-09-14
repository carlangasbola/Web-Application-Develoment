package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProducts extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             
            // De esta forma recuperamos los parametros de cualquier tienda
            Enumeration enum1 = request.getParameterNames();
            while(enum1.hasMoreElements())
            {
                ;
                String nombre = (String) enum1.nextElement();
                String valores[] = request.getParameterValues(nombre);
                if (valores != null) {
                    for (int i = 0; i < valores.length; i++) {
                        Cookie galleta = new Cookie (nombre,valores[i]);
                        out.println(nombre + " (" + i + "): " + valores[i]);
                        response.addCookie(galleta);
                }   
            }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Guardado </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Guardado en el carrito :D </h1>");
            out.println("<a href='index.html'> Regresa </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   

}
