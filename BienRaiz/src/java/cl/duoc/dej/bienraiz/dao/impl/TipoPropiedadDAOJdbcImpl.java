

package cl.duoc.dej.bienraiz.dao.impl;

import cl.duoc.dej.bienraiz.dao.TipoPropiedadDAO;
import cl.duoc.dej.bienraiz.model.TipoPropiedad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TipoPropiedadDAOJdbcImpl implements TipoPropiedadDAO {
    Connection connection;
    

    public TipoPropiedadDAOJdbcImpl(Connection connection) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.connection = connection;
        
    }

    @Override
    public boolean agregar(TipoPropiedad propiedad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(TipoPropiedad propiedad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(int id, TipoPropiedad propiedad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoPropiedad buscar(TipoPropiedad propiedad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoPropiedad> listar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         List<TipoPropiedad> listaTP = new ArrayList<>();
         String queryTipoSQL ="SELECT * FROM tipo_propiedad";
        try {
            Statement statement = connection.createStatement();
            statement.execute(queryTipoSQL);
            ResultSet resultSet = statement.getResultSet();
            TipoPropiedad tp;
            
            while(resultSet.next()){
                tp = new TipoPropiedad();
                tp.setId(resultSet.getInt("id"));
                tp.setNombre(resultSet.getString("nombre"));
                listaTP.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoPropiedadDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (listaTP.size()>0) {
            System.out.println("Lista Propiedades");
        }else{
            System.out.println("No lista propiedades");
        }
        return listaTP;
    }

    @Override
    public boolean eliminar(TipoPropiedad elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
