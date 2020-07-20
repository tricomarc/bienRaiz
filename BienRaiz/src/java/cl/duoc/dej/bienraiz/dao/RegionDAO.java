

package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Region;
import java.util.List;



public interface RegionDAO extends BaseDAO<Region>{
    
    @Override
    boolean agregar (Region region);
    @Override
    boolean actualizar (Region region);
    @Override
    boolean eliminar (Region region);
    @Override
    Region buscar (Region region);
    @Override
    List<Region> listar();    
    
}
