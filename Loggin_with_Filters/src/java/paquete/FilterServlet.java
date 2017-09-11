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

public class FilterServlet implements Filter {
    
// Solo los miembros de esta clase los accesan
private ServletContext context;
@Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
        //Recuperamos la solicitud
        HttpServletRequest request = (HttpServletRequest) req;
        String id=request.getParameter("id");
        context.log("User:"+id);
        System.out.println("User:"+id);
        // cadena de responsabilidades
        chain.doFilter(req, res);
    }
    
    //Inicializamos los recursos que vamos a ocupar
@Override
    public void init(FilterConfig config) throws ServletException {
    context=config.getServletContext();
    }
@Override
    public void destroy() {
    }
}