package paquete;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import entity.HibernateUtil;
import entity.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Insertar extends ActionSupport {
    
    private String nombre;
    private String password;
    private Session hibernateSession;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Insertar() {
    }
    
    public String execute() throws Exception {
        
       
        hibernateSession=HibernateUtil.getSessionFactory().openSession();
        Transaction t=hibernateSession.beginTransaction(); 
        
        t.commit();
        
        return "success";
        
    }
    
}
