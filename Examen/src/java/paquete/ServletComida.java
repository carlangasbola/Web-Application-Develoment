package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletComida extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            Connection db;
            Statement s;
            ResultSet rs;
            
            Class.forName("com.mysql.jdbc.Driver");
            db = DriverManager.getConnection("jdbc:mysql://localhost/Articulos", "root", "hola");
            s = db.createStatement();
            
            rs= s.executeQuery("select *from comida");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Tienda de ROPA </title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println( " <form action='SaveProducts' methos='get' >" );
            
            while(rs.next()){
                
                out.println( "Producto "    + rs.getString("nombre") + 
                             " Precio : "   + rs.getString("precio") + 
                             " cantidad : " + rs.getString("cantidades") + 
                             " <input type='text' name= '"+rs.getString("nombre") + "' placeholder='Cuantos quiere?' />" );
                
                out.println(" <br> ");
                out.println(" <br> ");
            }
            
            out.println("<input type='submit' >");
            out.println(" </form> ");
            
            out.println("</body>");
            out.println("</html>");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletRopa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRopa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   

  

}
