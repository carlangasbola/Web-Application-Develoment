package Calculos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecibeDatos extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Float a = Float.parseFloat( request.getParameter("A") );
            Float b = Float.parseFloat( request.getParameter("B") );
            Float c = Float.parseFloat( request.getParameter("C") );
            Double d = (Math.pow(b, 2) - 4*a*c );
            // Validamos el discriminante para verificar si existen raicez complejas
            if ( d < 0 ){
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet1</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Las Raicez son complejas </h1>");
                out.println("</body>");
                out.println("</html>");
            
            }else{
                response.sendRedirect("CalculaRaiz?a=" + a  + "&b=" + b + "&c=" + c + "&d=" + d );
            }
        
    }
}
