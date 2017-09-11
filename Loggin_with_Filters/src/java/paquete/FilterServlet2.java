package paquete;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterServlet2 implements Filter {
private ServletContext context;
@Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;       
        String password=request.getParameter("password");
        context.log("Password:"+password);
        System.out.println("Password:"+password);
        chain.doFilter(req, res);
    }
@Override
    public void init(FilterConfig config) throws ServletException {
    context=config.getServletContext();
    }
@Override
    public void destroy() {
    }
}