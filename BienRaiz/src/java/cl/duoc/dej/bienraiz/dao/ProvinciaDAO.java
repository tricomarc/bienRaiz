

package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Provincia;
import java.util.List;


public interface ProvinciaDAO extends BaseDAO<Provincia>{
    
    @Override
    boolean agregar (Provincia provincia);
    @Override
    boolean actualizar (Provincia provincia);
    @Override
    boolean eliminar (Provincia provincia);
    @Override
    Provincia buscar (Provincia provincia);
    @Override
    List<Provincia> listar();
    
}
