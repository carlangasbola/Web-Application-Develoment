package entity;

public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String password;
     private String tipo;
     
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     

    public Usuario() {
    }

    public Usuario(String nombre, String password, String tipo) {
       this.nombre = nombre;
       this.password = password;
       this.tipo = tipo;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


