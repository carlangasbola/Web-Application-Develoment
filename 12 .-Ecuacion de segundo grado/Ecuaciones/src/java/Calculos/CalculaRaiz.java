package Calculos;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculaRaiz extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            Double x1,x2;
            Float a = Float.parseFloat( request.getParameter("a") );
            Float b = Float.parseFloat( request.getParameter("b") );
            Float c = Float.parseFloat( request.getParameter("c") );
            Float d = Float.parseFloat( request.getParameter("d") );
            
            x1 = ( -b + Math.sqrt(d) )/2*a;
            x2 = ( -b - Math.sqrt(d) )/2*a;
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Las soluciones son </h1>");
            
            out.println("<p> a = "+ a + "  </p>");
            out.println("<p> b = "+ b + " </p>");
            out.println("<p> c = "+ c + " </p>");
            out.println("<br><br>");
            out.println("<p> x1 = "+ x1 + " </p>");
            out.println("<p> x2 = "+ x2 + " </p>");
            
            out.println("</body>");
            out.println("</html>");
        
    }
}