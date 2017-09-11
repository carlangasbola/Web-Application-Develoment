package paquete;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String id= request.getParameter("id");
        String password= request.getParameter("password");        
        HttpSession sesion=request.getSession();
        sesion.setAttribute("userName",id);
        response.setContentType("text/html;charset=UTF-8");
        LoginBean lb = new LoginBean();
        
        // Son argumentos cuando ya tienen valores establecidos o mejor dicho
        // valores concretos
        if(lb.validateUser(id,password))
        {
            
            try {
                if ( lb.tipoUsuaio(id) == 0 ){
                    response.sendRedirect("Admin1");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if ( lb.tipoUsuaio(id) == 1){
                    response.sendRedirect("Profesor1");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if (lb.tipoUsuaio(id) == 2){
                    response.sendRedirect("Alumno1");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else	// username/password not validated
        {
        response.sendRedirect("fail");
        }
    }
}
