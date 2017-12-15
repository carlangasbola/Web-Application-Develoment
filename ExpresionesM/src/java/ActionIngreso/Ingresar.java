package ActionIngreso;

import com.opensymphony.xwork2.ActionSupport;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;


public class Ingresar extends ActionSupport implements SessionAware{

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Usuarios> getLista() {
        return lista;
    }

    public void setLista(List<Usuarios> lista) {
        this.lista = lista;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    private List <Grupo> grupos;
    private SessionMap<String, Object> sessionMap;
    private List <Usuarios> lista;
    private String userName;
    private String password;
    public Session hibernateSession;
    
    @Override
    public String execute() throws Exception {
        
        //Recuperación de la sessión
        HttpSession session = ServletActionContext.getRequest().getSession(true);
        grupos = new ArrayList();
        lista = new ArrayList();
        hibernateSession=HibernateUtil.getSessionFactory().openSession(); 
        hibernateSession.beginTransaction();
        Query query = hibernateSession.createQuery("from Usuarios where "
                                                   + " userNameIn = :userName and  "
                                                   + " passwordIn = :password ");
        
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        
        lista = query.list();
        
        // No esta el usuario en la base de datos
        if(lista.isEmpty()){
            addActionError("I don't know you, dont try to hack me!!");
            return "fallo";
        }else{
            //Recuperamos el tipo de usuario
            String tipo = lista.get(0).getTipoIn();
            //Subimos a sesicon el nombre del usuario para mostrarlo 
            sessionMap.put("userId", lista.get(0).getUserNameIn());
            if (tipo.equals("administrador"))
                return "administrador";
            else if (tipo.equals("profesor")){
                // Con esta sentencia recuperamos el nombre de los grupos en el que se encuentra
                // el usuario para que sepa en que salón puede crear diagramas o
                // el alumno vea si tiene algun diagrama disponible
                query = hibernateSession.createSQLQuery("select distinct ref_nombregrupo from usuarios "
                                                      + "join relacionGrupos where ref_idUser= :id");
                query.setParameter("id", lista.get(0).getIdUser());
                grupos = query.list();
                return "profesor";
            }
            else if (tipo.equals("alumno")){
                query = hibernateSession.createSQLQuery("select distinct ref_nombregrupo from usuarios "
                                                      + "join relacionGrupos where ref_idUser= :id");
                query.setParameter("id", lista.get(0).getIdUser());
                grupos = query.list();
                return "alumno";
            }
        }
        
        return "fallo";
    }

    @Override
	public void setSession(Map<String, Object> map) {
            sessionMap = (SessionMap<String, Object>) map;
    }
        
    public String logout() {
        sessionMap.remove("userId");
	sessionMap.invalidate();
	return "LOGOUT";
    }    
    
}
