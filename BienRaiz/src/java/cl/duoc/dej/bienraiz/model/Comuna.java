
package cl.duoc.dej.bienraiz.model;


public class Comuna {
    
     private int id;
     private String nombre;
     private Provincia id_provincia;

    public Comuna() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Provincia id_provincia) {
        this.id_provincia = id_provincia;
    }
     
     
}
