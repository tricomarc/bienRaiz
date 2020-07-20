

package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Comuna;
import java.util.List;



public interface ComunaDAO extends BaseDAO<Comuna> {
    
    @Override
    boolean agregar (Comuna comuna);
    @Override
    boolean actualizar (Comuna comuna);
    @Override
    boolean eliminar (Comuna comuna);
    @Override
    Comuna buscar (Comuna comuna);
    @Override
    List<Comuna> listar();
    
}
