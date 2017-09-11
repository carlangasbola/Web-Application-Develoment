package administrador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
            
            // getRealPath : Transforma Rutas Virtuales en rutas reales
            // Esta es la manea incorrecta esta depreciada
            String ruta1=request.getRealPath("/");
            
            // Esta es la manera correcta de utilizar el getRealPath
            ServletContext application =this.getServletContext();
            String ruta = application.getRealPath("/");
            
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ruta1: " + ruta1 + "</h1>");
            out.println("<h1>Ruta1: " + ruta + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
    }  
 
}
