package paquete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/* */
class LoginBean 
{
    /* Un HasMap nos permite hacer una relacion entre valores */
    private HashMap validUsers = new HashMap(); 
    private HashMap tipoUsers = new HashMap();
    Connection db;
    Statement s;
    ResultSet rs;
    
    
    /* 
       Caracteristicas de un constructo ///
       Puede ser sobrecargado
       Tiene el mismo nombre de la clase
       no retorna nada */
    
    public LoginBean()
    {
        int n;
        // EN el contructor se agrega la conexion a la base de datos
            try{
            	// Carga el driver en tiempo de ejecuacion
                Class.forName("com.mysql.jdbc.Driver");
                                                                        //Nombre de la base //Usuario yo uso "root" //contrasenia
                db = DriverManager.getConnection("jdbc:mysql://localhost/TUBASEDEDATOS", "TUUSUARIOMYSQL", "TUCONTRASEÑA");
                s = db.createStatement(); // Recupere todas las columnas
                
                rs= s.executeQuery("select *from usuarios");
                
                
                while(rs.next()){
                   /* Agregamos los valores al hash map */
                    validUsers.put(rs.getString("usuario"), rs.getString("pass") );
                    
                }
                
            }catch( Exception e ){
                
            }
            
    }
    
    public int tipoUsuaio(String userName) throws SQLException{
        
        rs = s.executeQuery("select tipo from usuarios where usuario='"+ userName + "'");
        return rs.getInt("tipo");
    }
    
    public boolean validateUser(String userName, String password)
    {       
            
            // Si existe en la tabla has map
            if(validUsers.containsKey(userName))
            {
             // Se hace un casting por que regresa un tipo Objtect 
             String thePassword = (String)validUsers.get(userName);
             if(thePassword.equals(password))
             return true;
            }
        return false;
    }
    
 

}
