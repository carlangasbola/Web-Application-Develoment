
package administrator;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlets2 extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            ServletContext application = this.getServletContext();
            //EJEMPLO DE USO EN UN LOGOUT de una aplicación web
            String clave =  (String) application.getAttribute("clave");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() +" " + clave + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
    }
}