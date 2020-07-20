
package cl.duoc.dej.bienraiz.model;

public class Favorito {
    
    private Usuario id_usuario;
    private BienRaiz id_bienraiz;

    public Favorito(){
        
    }
    
    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public BienRaiz getId_bienraiz() {
        return id_bienraiz;
    }

    public void setId_bienraiz(BienRaiz id_bienraiz) {
        this.id_bienraiz = id_bienraiz;
    }
    
    
    
    
}
