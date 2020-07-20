

package cl.duoc.dej.bienraiz.dao;

import java.util.List;


public interface BaseDAO<T> {
    boolean agregar (T elemento);
    boolean actualizar (T elemento);
    boolean eliminar ( T elemento);
    T buscar (T elemento);
    List<T> listar();
    
}
