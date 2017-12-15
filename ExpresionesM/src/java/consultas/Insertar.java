package consultas;

import com.opensymphony.xwork2.ActionSupport;
import entity.Diagrama;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Insertar extends ActionSupport {
    
    // recuperación de la sesion
    public Insertar() {
        hibernateSession=HibernateUtil.getSessionFactory().openSession();
    }
    
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

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIdDiagrama() {
        return idDiagrama;
    }

    public void setIdDiagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    
    private int idDiagrama;
    private String info; 
    //Declaración de variables
    public Session hibernateSession;
    // Varibales usuarios
    private String nombre;
    private String password;
    private String tipo;
    // Variables para grupo
    private String nombregrupo;
    
    //Metodos para insertar grupos y usuarios 
    
    public String insertarUsuario(){
        Transaction t = hibernateSession.beginTransaction();
        Usuarios user = new Usuarios(nombre,password,tipo);
        hibernateSession.save(user);
        t.commit();
        return "exito";
    }
    
    public String insertarGrupo(){
        Transaction t = hibernateSession.beginTransaction();
        Grupo group = new Grupo(nombregrupo);
        hibernateSession.save(group);
        t.commit();
        return "exito";
    }
    
    public String relacionarUsuario(){
        List<Usuarios> lista = new ArrayList();
        Transaction t = hibernateSession.beginTransaction();
        // recuperamos el grupo
        Grupo group = (Grupo) hibernateSession.get(Grupo.class, nombregrupo );
        // recuperamos el usuario
        Query query = hibernateSession.createQuery("select idUser from Usuarios where userNameIn= :nombre");
        query.setParameter("nombre", nombre);
        Integer id = (Integer) query.uniqueResult();
        Usuarios user = (Usuarios) hibernateSession.get(Usuarios.class, id);
        // Hay que hacer una validacion puede existir un error
        user.getGrupos().add(group);
        t.commit();
        return "exito";
    }
    
    public String Insertapagina(){
        Transaction t = hibernateSession.beginTransaction();
        Diagrama diagrama = new Diagrama(info);
        hibernateSession.save(diagrama);
        t.commit();
        return "exito";
    }
    
    public String insertarAsignacionDiagrama(){
        Transaction t = hibernateSession.beginTransaction();
        Grupo group = (Grupo) hibernateSession.get(Grupo.class, nombregrupo );
        Diagrama diagrama = (Diagrama) hibernateSession.get(Diagrama.class, idDiagrama);
        group.getDiagramas().add(diagrama);
        t.commit();
        return "exito";
        
    }
    
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
