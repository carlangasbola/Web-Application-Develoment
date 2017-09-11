package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    
    Vector sites = new Vector();
    Random random = new Random();

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    sites.addElement("http://www.oreilly.com/catalog/jservlet");
    sites.addElement("http://www.servlets.com");
    sites.addElement("http://jserv.java.sun.com");
    sites.addElement("http://www.servletcentral.com");
  }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    int siteIndex = Math.abs(random.nextInt()) % sites.size();
    String site = (String)sites.elementAt(siteIndex);

    res.setStatus(res.SC_MOVED_TEMPORARILY);
    res.setHeader("Location", site);
    }
}