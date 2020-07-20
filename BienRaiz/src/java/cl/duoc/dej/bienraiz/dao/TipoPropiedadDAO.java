

package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.TipoPropiedad;
import java.util.List;

public interface TipoPropiedadDAO extends BaseDAO<TipoPropiedad>{
    
    @Override
    boolean agregar (TipoPropiedad propiedad);
    @Override
    boolean actualizar (TipoPropiedad propiedad);
    @Override
    boolean eliminar (TipoPropiedad propiedad);
    @Override
    TipoPropiedad buscar (TipoPropiedad propiedad);
    @Override
    List<TipoPropiedad> listar();
    
}
