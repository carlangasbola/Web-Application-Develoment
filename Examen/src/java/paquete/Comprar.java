
package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Comprar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Comprar</title>");            
            out.println("</head>");
            out.println("<body>");
            Cookie[] galletas = request.getCookies();
            //out.println("galletas:"+galletas.toString());
            out.println(" Esto compraras <br><br> ");
            for(int i=0;i<galletas.length;i++)
            {
              out.println(" Producto :"+galletas[i].getName()+" Precio : " + galletas[i].getValue() + "<br><br>");
              
            }
            
            out.println("</body></html>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  

}
