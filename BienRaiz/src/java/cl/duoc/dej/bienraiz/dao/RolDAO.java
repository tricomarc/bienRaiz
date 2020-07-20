

package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Rol;
import java.util.List;


public interface RolDAO extends BaseDAO<Rol>{
    
    @Override
    boolean agregar (Rol rol);
    @Override
    boolean actualizar (Rol rol);
    @Override
    boolean eliminar (Rol rol);
    @Override
    Rol buscar (Rol rol);
    @Override
    List<Rol> listar();
    
    
}
