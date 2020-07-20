
package cl.duoc.dej.bienraiz.dao.impl;

import cl.duoc.dej.bienraiz.dao.BienRaizDAO;
import cl.duoc.dej.bienraiz.model.BienRaiz;
import cl.duoc.dej.bienraiz.model.Comuna;
import cl.duoc.dej.bienraiz.model.TipoPropiedad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.annotation.Resource;
//import javax.sql.*;


public class BienRaizDAOJdbcImpl implements BienRaizDAO{
    // Esto se escribe en el servlet
//    @Resource(name="jdbc/bienraizDS")
//    //Recibe la conexión        
//    DataSource dataSource;
    Connection connection;
    
    
    public BienRaizDAOJdbcImpl(Connection connection){
         
       // connection = dataSource.getConnection();
        this.connection = connection;
        
    }
    
    @Override
    public boolean agregar(BienRaiz bienRaiz) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean creado = false;
        
        try{
            String querySQLInsertar = "INSERT INTO bien_raiz"
                    + "(id,"
                    + "titulo,"
                    + "descripcion,"
                    + "direccion,"
                    + "id_comuna,"
                    + "tipo_propiedad,"
                    + "metros_cuadrados,"
                    + "cantidad_dormitorios,"
                    + "cantidad_banios,"
                    + "otros,"
                    + "coordenada_latitud,"
                    + "coordenada_longitud)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement smt = this.connection.prepareStatement(querySQLInsertar);
            smt.setInt(1, bienRaiz.getId());
            smt.setString(2, bienRaiz.getTitulo());
            smt.setString (3, bienRaiz.getDescripcion());
            smt.setString(4, bienRaiz.getDireccion());
            Comuna c = new Comuna();
            c = bienRaiz.getId_comuna();
            smt.setInt(5, c.getId());
            TipoPropiedad tp = new TipoPropiedad();
            tp = bienRaiz.getTipo_propiedad();
            smt.setInt(6, c.getId());
            smt.setInt(7, bienRaiz.getMetros_cuadrados());
            smt.setInt(8, bienRaiz.getCantidad_dormitorios());
            smt.setInt(9, bienRaiz.getCantidad_banios());
            smt.setString(10, bienRaiz.getOtros());
            smt.setFloat(11, bienRaiz.getCoordenada_latitud());
            smt.setFloat(12,bienRaiz.getCoordenada_longitud());
            
            smt.executeUpdate();
            creado = true;
            System.out.println("SE ejecuto consulta agregar y funciona!");
        }catch(Exception ex){
               System.out.println("SE ejecuto consulta agregar y NO funciona!");
        Logger.getLogger(BienRaizDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return creado;
    }

    @Override
    public boolean actualizar(BienRaiz bienRaiz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean eliminar(int id, BienRaiz bienRaiz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BienRaiz buscar(BienRaiz bienRaiz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BienRaiz> listar() {
        
        List<BienRaiz> lista = new ArrayList<>();
        
        String querySQL = "SELECT bien_raiz.id,"
                + " bien_raiz.titulo,"
                + " bien_raiz.descripcion,"
                + " bien_raiz.direccion,"
                + " comuna.id,"
                + " comuna.nombre,"
                + " tipo_propiedad.id,"
                + " tipo_propiedad.nombre,"
                + " bien_raiz.metros_cuadrados,"
                + " bien_raiz.cantidad_dormitorios,"
                + " bien_raiz.cantidad_banios,"
                + " bien_raiz.otros,"
                + " bien_raiz.coordenada_latitud,"
                + " bien_raiz.coordenada_longitud"
                + " FROM bien_raiz INNER JOIN comuna"
                + " ON bien_raiz.id = comuna.id "
                + "INNER JOIN tipo_propiedad "
                + "ON bien_raiz.id = tipo_propiedad.id";
        
        try {

            Statement statement = connection.createStatement();
            statement.execute(querySQL);
            ResultSet resultSet = statement.getResultSet();
            BienRaiz bienraiz;
                
            while(resultSet.next()) {
                
                
                bienraiz = new BienRaiz();
            
                // Falta arreglar 
                Comuna c = new Comuna();
                TipoPropiedad tp = new TipoPropiedad();
             
              //  c.setNombre(resultSet.getString("nombre_comuna"));
                
               // bienraiz.setTipo_propiedad(resultSet.getInt("tipo_propiedad"));
                
                // Falta arreglar 
                
                bienraiz.setId(resultSet.getInt("bien_raiz.id"));
                bienraiz.setTitulo(resultSet.getString("bien_raiz.titulo"));
                bienraiz.setDescripcion(resultSet.getString("bien_raiz.descripcion"));
                bienraiz.setDireccion(resultSet.getString("bien_raiz.direccion"));
                c.setId(resultSet.getInt("comuna.id"));
                c.setNombre(resultSet.getString("comuna.nombre"));
                tp.setId(resultSet.getInt("tipo_propiedad.id"));
                tp.setNombre(resultSet.getString("tipo_propiedad.nombre"));
                bienraiz.setMetros_cuadrados(resultSet.getInt("bien_raiz.metros_cuadrados"));
                bienraiz.setCantidad_dormitorios(resultSet.getInt("bien_raiz.cantidad_dormitorios"));
                bienraiz.setCantidad_banios(resultSet.getInt("bien_raiz.cantidad_banios"));
                bienraiz.setOtros(resultSet.getString("bien_raiz.otros"));
                bienraiz.setCoordenada_latitud(resultSet.getFloat("bien_raiz.coordenada_longitud"));
                bienraiz.setCoordenada_longitud(resultSet.getFloat("bien_raiz.coordenada_longitud"));
                bienraiz.setId_comuna(c);
                bienraiz.setTipo_propiedad(tp);
                
                System.out.println("Lista Propiedades");
                
                lista.add(bienraiz);
            }

            
        } catch (Exception ex) {
          Logger.getLogger(BienRaizDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
       
            System.out.println("ERROR CONSULTA QUERY: " + ex.getMessage());System.out.println("No listo");
        }
        
        return lista;
        
        
    }

    @Override
    public boolean eliminar(BienRaiz bienRaiz) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean elimina = false;
        try{
            String querySQLEliminar = "DELETE FROM bien_raiz WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(querySQLEliminar);
            statement.setInt(1, bienRaiz.getId());
            statement.executeUpdate();
            System.out.println("Se elimino propiedad");
            elimina = true;
        }catch(SQLException ex){
            System.out.println("No elimina propiedad");
            Logger.getLogger(BienRaizDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elimina;
    }

    @Override
    public List<BienRaiz> listarID(BienRaiz bienraiz) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<BienRaiz> listaID = new ArrayList<>();
        String consulta ="SELECT bien_raiz.id,"
                + " bien_raiz.titulo,"
                + " bien_raiz.descripcion,"
                + " bien_raiz.direccion,"
                + " comuna.id,"
                + " comuna.nombre,"
                + " tipo_propiedad.id,"
                + " tipo_propiedad.nombre,"
                + " bien_raiz.metros_cuadrados,"
                + " bien_raiz.cantidad_dormitorios,"
                + " bien_raiz.cantidad_banios,"
                + " bien_raiz.otros,"
                + " bien_raiz.coordenada_latitud,"
                + " bien_raiz.coordenada_longitud"
                + " FROM bien_raiz INNER JOIN comuna"
                + " ON bien_raiz.id = comuna.id "
                + "INNER JOIN tipo_propiedad "
                + "ON bien_raiz.id = tipo_propiedad.id"
                + "WHERE bien_raiz.id = ?" ;

                
        try {
            PreparedStatement statement   = connection.prepareStatement(consulta);
            statement.setInt(1, bienraiz.getId());
            ResultSet resultSet = statement.executeQuery();
            Comuna comuna;
            TipoPropiedad tipo;
            
            while(resultSet.next()){
                comuna = new Comuna();
                tipo = new TipoPropiedad();
                bienraiz.setId(resultSet.getInt("bien_raiz.id"));
                bienraiz.setTitulo(resultSet.getString("bien_raiz.titulo"));
                bienraiz.setDescripcion(resultSet.getString("bien_raiz.descripcion"));
                comuna.setId(resultSet.getInt("comuna.id"));
                comuna.setNombre(resultSet.getString("comuna.nombre"));
                tipo.setId(resultSet.getInt("tipo_propiedad.id"));
                tipo.setNombre(resultSet.getString("tipo_propiedad.nombre"));
                bienraiz.setMetros_cuadrados(resultSet.getInt("bien_raiz.metros_cuadrados"));
                bienraiz.setCantidad_dormitorios(resultSet.getInt("bien_raiz.cantidad_dormitorios"));
                bienraiz.setCantidad_banios(resultSet.getInt("bien_raiz.cantidad_banios"));
                bienraiz.setOtros(resultSet.getString("bien_raiz.otros"));
                bienraiz.setCoordenada_latitud(resultSet.getFloat("bien_raiz.coordenada_latitud"));
                bienraiz.setCoordenada_longitud(resultSet.getFloat("bien_raiz.coordenada_longitud"));
                bienraiz.setId_comuna(comuna);
                bienraiz.setTipo_propiedad(tipo);
                
                listaID.add(bienraiz);
                System.out.println("LISTA CON ID");
            }
        } catch (SQLException ex) {
            System.out.println("NO LISTA CON ID");
            Logger.getLogger(BienRaizDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }                
        return listaID;
    }
    
}
