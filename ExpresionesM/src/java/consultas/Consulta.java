package consultas;

import com.opensymphony.xwork2.ActionSupport;
import entity.Diagrama;

import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;


public class Consulta extends ActionSupport {
    
    // Inicializa los arrays y la sesion de hibernate
    public Consulta(){
        hibernateSession=HibernateUtil.getSessionFactory().openSession(); 
        lista_usuarios = new ArrayList();
        lista_grupo = new ArrayList();
    }
    
    // Declaraion de los metodos getter y setter
    public List<Usuarios> getLista_usuarios() {
        return lista_usuarios;
    }

    public void setLista_usuarios(List<Usuarios> lista_usuarios) {
        this.lista_usuarios = lista_usuarios;
    }

    public List<Grupo> getLista_grupo() {
        return lista_grupo;
    }

    public void setLista_grupo(List<Grupo> lista_grupo) {
        this.lista_grupo = lista_grupo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<String> getLista1() {
        return lista1;
    }

    public void setLista1(List<String> lista1) {
        this.lista1 = lista1;
    }

    public List<String> getLista2() {
        return lista2;
    }

    
    public void setLista2(List<String> lista2) {
        this.lista2 = lista2;
    }
    
    
    public List getLista3() {
        return lista3;
    }

    public void setLista3(List lista3) {
        this.lista3 = lista3;
    }

    public List<Diagrama> getLista_diagrama() {
        return lista_diagrama;
    }

    public void setLista_diagrama(List<Diagrama> lista_diagrama) {
        this.lista_diagrama = lista_diagrama;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public int getIdDiagrama() {
        return idDiagrama;
    }

    public void setIdDiagrama(int idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    
    
    
    private int idDiagrama;
    private String json;
    private List <Diagrama> lista_diagrama;
    // Declaracion de variables
    // lista1 : Usuarios
    // lista2 : Grupos
    private List<String> lista1,lista2;
    private List lista3;
    private int idUser;
    private List <Usuarios> lista_usuarios;
    private List <Grupo> lista_grupo;
    public Session hibernateSession;
    
    // Consultas
    
    public String getDiagramaAndGrupo(){
         lista1 = new ArrayList(); 
         lista2 = new ArrayList();
         hibernateSession.beginTransaction();
         Query query1 =hibernateSession.createQuery("from Grupo");
         lista_grupo = query1.list();
         Query query2 =hibernateSession.createQuery("from Diagrama");
         lista_diagrama = query2.list();
         
         for ( int i=0; i<lista_grupo.size(); i++ ){
            lista1.add(lista_grupo.get(i).getNombregrupo() );
        }
         
         for ( int i=0; i<lista_diagrama.size(); i++ ){
            lista2.add(lista_diagrama.get(i).getIdDiagrama().toString() );
        }
         
         return "exito";
    }
    
    public String getUsuariosAndGrupos(){
        int i;
                
        lista1 = new ArrayList(); 
        lista2 = new ArrayList();
        lista3 = new ArrayList();
        
        hibernateSession.beginTransaction();
        Query query1 =hibernateSession.createQuery("from Usuarios where not tipoIn='administrador'");
        lista_usuarios = query1.list();
        Query query2 =hibernateSession.createQuery("from Grupo");
        lista_grupo = query2.list();
        
        /*FUNCIONA PERO AUN NO ESTA BIEN HECHO*/
        Query query3 = hibernateSession.createSQLQuery("select distinct idUser,userNameIn,ref_nombregrupo from usuarios "
                                                     + " join relacionGrupos "
                                                     + " where ref_idUser=idUser");
        lista3 =  query3.list();
        //Lista 1 y 2 iteran sobre la lista de usuarios y grupos
        //porque para visualizar en ajax hay que recuperar una lista de tipo String
        
        for (  i=0; i<lista_usuarios.size(); i++ ){
            lista1.add(lista_usuarios.get(i).getUserNameIn() );
        }
        
        for (  i=0; i<lista_grupo.size(); i++ ){
            lista2.add(lista_grupo.get(i).getNombregrupo());
        }
        
        return "exito";
    }
    
    //Obtener todos los usuarios
    public String getUsuarios(){
        hibernateSession.beginTransaction();
        Query query =hibernateSession.createQuery("from Usuarios");
        lista_usuarios = query.list();
        return "exito";
    }
    
    //Obtener todos  los grupos
    public String getGrupos(){
        hibernateSession.beginTransaction();
        Query query =hibernateSession.createQuery("from Grupo");
        lista_grupo = query.list(); 
        return "exito";
    }
   
    //Obtener un usuario
    public String getUsuario(){
        hibernateSession.beginTransaction();
        Query query =hibernateSession.createQuery("from Usuarios where idUser = :idUser");
        query.setParameter("idUser", idUser);
        lista_usuarios = query.list();
        return "exito";
    }
    
    //Obtener los diagramas
    public String getDiagramas(){
        hibernateSession.beginTransaction();
        Query query =hibernateSession.createQuery("from Diagrama ");
        lista_diagrama = query.list();
        return "exito";
    }
    
    public String getJsonDiagrama(){
        hibernateSession.beginTransaction();
        Query query = hibernateSession.createQuery("select json from Diagrama where idDiagrama= :idDiagrama");
        query.setParameter("idDiagrama", idDiagrama);
        json = (String) query.uniqueResult();
        return "exito";
    }
    
    
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
