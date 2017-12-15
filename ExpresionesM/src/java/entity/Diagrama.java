package entity;
// Generated 6/12/2017 09:09:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Diagrama generated by hbm2java
 */
public class Diagrama  implements java.io.Serializable {


     private Integer idDiagrama;
     private String json;
     private Set grupos = new HashSet(0);

    public Diagrama() {
    }

	
    public Diagrama(String json) {
        this.json = json;
    }
    public Diagrama(String json, Set grupos) {
       this.json = json;
       this.grupos = grupos;
    }
   
    public Integer getIdDiagrama() {
        return this.idDiagrama;
    }
    
    public void setIdDiagrama(Integer idDiagrama) {
        this.idDiagrama = idDiagrama;
    }
    public String getJson() {
        return this.json;
    }
    
    public void setJson(String json) {
        this.json = json;
    }
    public Set getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Set grupos) {
        this.grupos = grupos;
    }




}


