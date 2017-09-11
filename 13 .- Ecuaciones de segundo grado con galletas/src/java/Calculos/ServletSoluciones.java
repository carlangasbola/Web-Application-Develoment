
package Calculos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletSoluciones extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Cookie[] cookie = request.getCookies();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSoluciones</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1> Las soluciones encontradas son </h1><br><br>");
            
             for(int i=0;i<cookie.length;i++){
                 out.println( cookie[i].getName() + " " + cookie[i].getValue() );
             }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    

}
