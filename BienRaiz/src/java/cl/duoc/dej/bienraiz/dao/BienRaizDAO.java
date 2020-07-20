
package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.BienRaiz;
import java.util.List;


public interface BienRaizDAO extends BaseDAO<BienRaiz>{
    
        @Override
    boolean agregar (BienRaiz bienRaiz);
    @Override
    boolean actualizar (BienRaiz bienRaiz);
    @Override
    boolean eliminar (BienRaiz bienRaiz);
    @Override
    BienRaiz buscar (BienRaiz bienRaiz);
    
    @Override
    List<BienRaiz> listar();
    public List<BienRaiz> listarID(BienRaiz bienraiz);
}
