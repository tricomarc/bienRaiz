

package cl.duoc.dej.bienraiz.dao.impl;

import cl.duoc.dej.bienraiz.dao.ComunaDAO;
import cl.duoc.dej.bienraiz.model.Comuna;
import java.sql.Connection;
import java.util.List;
import javax.activation.DataSource;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ComunaDAOJdbcImpl implements ComunaDAO {

    
//      @Resource(name="jdbc/bienraizDS")
//    //Recibe la conexión        
//    DataSource dataSource;
    
    Connection connection;
    
    public ComunaDAOJdbcImpl(Connection connection){
         
    //    connection = dataSource.getConnection();
        this.connection = connection;
        
    }
    
    @Override
    public boolean agregar(Comuna comuna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Comuna comuna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(int id, Comuna comuna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comuna buscar(Comuna comuna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comuna> listar() {
        
    List<Comuna> listaC = new ArrayList<>();
        String querySQL = " SELECT *FROM comuna";
        
        try {
            
            Statement statement = connection.createStatement();
            statement.execute(querySQL);
            ResultSet resultSet = statement.getResultSet();
            Comuna comuna;
            
             while(resultSet.next()) {
                 comuna =  new Comuna();
                 comuna.setId(resultSet.getInt("id"));
                 comuna.setNombre(resultSet.getString("nombre"));
            //     comuna.setId_provincia(resultSet.getInt("id_provincia"));
                                 
                listaC.add(comuna);
            }
            
            
        } catch (Exception ex) {
             System.out.println("ERROR CONSULTA QUERY: " + ex.getMessage());System.out.println("No listo");
      
        }
        
        return listaC;
    }

    @Override
    public boolean eliminar(Comuna elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
