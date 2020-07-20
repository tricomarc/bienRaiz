
package cl.duoc.dej.bienraiz.dao;

import cl.duoc.dej.bienraiz.model.Usuario;
import java.util.List;


public interface UsuarioDAO extends BaseDAO<Usuario>{
    
    @Override
    boolean agregar (Usuario usuario);
    
    @Override
    boolean actualizar (Usuario usuario);
    
    @Override
    boolean eliminar (Usuario usuario);
    
    @Override
    Usuario buscar (Usuario usuario);
    
    @Override
    List<Usuario> listar();
    
    public List<Usuario> listarFiltroEmail (Usuario usuario);
    
    
}
