package paquete;

import com.opensymphony.xwork2.ActionSupport;
import entity.HibernateUtil;
import entity.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class Ingreso extends ActionSupport {
    
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
    
    public Ingreso() {
    }
    
    public String execute() throws Exception {
        
        int i;
        // Recuperamos la session
        hibernateSession = HibernateUtil.getSessionFactory().openSession(); 
        //Sentencia en hql que nos regresara los resultados de la tabla
        String hql = "FROM  Usuario";
        //Obtencion de los resultados
        Query query = hibernateSession.createQuery(hql);
        List<Usuario> lista = query.list();
        
        // Iteracion de los resultados obtenidos
        for(i=0; i<lista.size(); i++){
            if ( lista.get(i).getNombre().equals(nombre) ){
                if (lista.get(i).getPassword().equals(password)){
                    // Si es administrador
                    // Si es alumno
                    // Si es profesor
                    if(lista.get(i).getTipo().equals("administrador")){
                        return "Administrador";
                    }else if(lista.get(i).getTipo().equals("profesor")){
                        return "Profesor";
                    }else if(lista.get(i).getTipo().equals("alumno")){
                        return "Alumno";
                    }
                    
                }
            }
        }
        
        return "Fail";
            
    }
    
}
