package consultas;

import com.opensymphony.xwork2.ActionSupport;
import entity.Diagrama;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Bajas extends ActionSupport {
    
    // Recuperamos la sesion en hibernate
    public Bajas(){
         hibernateSession=HibernateUtil.getSessionFactory().openSession(); 
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public int getIdDiagrama() {
        return idDiagrama;
    }

    public void setIdDiagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    
    private int idDiagrama;
    // Declaración de variables
    private String nombregrupo;
    private int idUser;
    public Session hibernateSession;
    
    
    // Eliminar Usuario
    public String bajaUsuario(){
        Transaction t=hibernateSession.beginTransaction(); 
        Usuarios user = ( Usuarios ) hibernateSession.get(Usuarios.class, idUser);
        hibernateSession.delete(user);
        t.commit();
        return "exito";
    }
    
    //Eliminar grupo
    public String bajaGrupo(){
        Transaction t=hibernateSession.beginTransaction(); 
        Grupo group = ( Grupo ) hibernateSession.get(Grupo.class, nombregrupo);
        hibernateSession.delete(group);
        t.commit();
        return "exito";
    }
    
    public String bajaAsignacion(){
        Transaction t=hibernateSession.beginTransaction();
        Usuarios user = ( Usuarios ) hibernateSession.get(Usuarios.class, idUser);
        Grupo group = ( Grupo ) hibernateSession.get(Grupo.class, nombregrupo);
        user.getGrupos().remove(group);
        t.commit();
        return "exito";
    }
    
    public String deleteDiagrama(){
        hibernateSession.beginTransaction();
        Diagrama diagram = (Diagrama) hibernateSession.get(Diagrama.class, idDiagrama);
        hibernateSession.delete(diagram);
        
        return "exito";
    }
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
