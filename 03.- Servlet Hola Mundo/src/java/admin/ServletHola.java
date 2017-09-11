package admin;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;



public class ServletHola extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html";
  //Initialize global variables
 
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter();
    out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HolaMundo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HolaMundo </h1>");
            out.println("</body>");
            out.println("</html>");
    
    }
  }
  

