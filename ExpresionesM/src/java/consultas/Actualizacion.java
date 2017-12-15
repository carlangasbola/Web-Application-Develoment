
package consultas;

import com.opensymphony.xwork2.ActionSupport;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Actualizacion extends ActionSupport {
    
    public Actualizacion() {
        hibernateSession=HibernateUtil.getSessionFactory().openSession(); 
    }
    
    public Session hibernateSession;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    private int id;
    private String password;
    private String tipo;
    private String nombre;
    
    
    public String updateAlumno(){
        Transaction t=hibernateSession.beginTransaction(); 
        Usuarios user = (Usuarios) hibernateSession.get(Usuarios.class, id);
        user.setUserNameIn(nombre);
        user.setPasswordIn(password);
        user.setTipoIn(tipo);
        t.commit();
        return "exito";
    }
    
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
