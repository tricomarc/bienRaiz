
package cl.duoc.dej.bienraiz.dao.impl;
import cl.duoc.dej.bienraiz.dao.RolDAO;
import cl.duoc.dej.bienraiz.model.Rol;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RolDAOJdbcImpl implements RolDAO {

    
    Connection connection;
    
    public RolDAOJdbcImpl(Connection connection){
       
        this.connection = connection;
        
    }
    
    @Override
    public boolean agregar(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(int id, Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol buscar(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> listar() {
        
        List<Rol> listaR = new ArrayList<>();
        
        String queryRolSQL = "SELECT * FROM rol";
    
        try{
            
            Statement statement = connection.createStatement();
            statement.execute(queryRolSQL);
            ResultSet resultSet = statement.getResultSet();
            Rol rol;
            
            while(resultSet.next()){
                
                rol = new Rol();
                rol.setId(resultSet.getInt("id"));
                rol.setNombre(resultSet.getString("nombre"));
                rol.setDescripcion(resultSet.getString("descripcion"));
                
                listaR.add(rol);
            }
            
            
        }catch (Exception ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA QUERY: " + ex.getMessage());System.out.println("No listo");
        
        }
        
        if(listaR.size()>0){
            System.out.println("Lista ROLES");
        }else{
            System.out.println("NO LISTA ROLES");
        }
        
        return listaR;        
    }

    @Override
    public boolean eliminar(Rol elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
