
package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Favorito;
import java.util.List;

public interface FavoritosDAO extends BaseDAO<Favorito>{
    
    @Override
    boolean agregar (Favorito favorito);
    @Override
    boolean actualizar (Favorito favorito);
    @Override
    boolean eliminar (Favorito favorito);
    @Override
    Favorito buscar (Favorito favorito);
    @Override
    List<Favorito> listar();
    
}
