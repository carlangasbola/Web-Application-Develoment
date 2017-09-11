import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            // Va al servidor a buscar las galletas
            Cookie[] galletas = request.getCookies();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("Galletas:"+galletas);
            
            for(int i=0;i<galletas.length;i++)
            {
                out.println("El nombre de la galleta es:"+galletas[i].getName()+"\n");
                out.println("El valor de la galleta es:"+galletas[i].getValue()+"\n");
            }
            
            out.println("</body>");
            out.println("</html>");
        
    }
}
