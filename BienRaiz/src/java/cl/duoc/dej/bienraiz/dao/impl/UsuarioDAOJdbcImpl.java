
package cl.duoc.dej.bienraiz.dao.impl;
import cl.duoc.dej.bienraiz.dao.UsuarioDAO;
import cl.duoc.dej.bienraiz.model.Rol;
import cl.duoc.dej.bienraiz.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAOJdbcImpl implements UsuarioDAO {

    Connection connection;
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioDAOJdbcImpl.class.getName());
   
    
    public UsuarioDAOJdbcImpl(UsuarioDAO daoUsuario) {
        LOGGER.info("Instanciando   " + daoUsuario);
      //  this.daoUsuario = daoUsuario;
    }
    
    public UsuarioDAOJdbcImpl(Connection connection){
        
         try {
             connection = connection;
         } catch (Exception ex) {
             Logger.getLogger(UsuarioDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        this.connection = connection;
    }
      

    @Override
    public boolean agregar(Usuario usuario) {
      //  throw new UnsupportedOperationException("Not supported yet."); 
      
        boolean creo = false;
        
        
        
        try {

            String querySQLInsertar = "INSERT INTO  usuario"
                    + "(email, nombre, apellido, clave, fecha_nacimiento,"
                    + "activo, rol ) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = this.connection.prepareStatement(querySQLInsertar);
            
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getApellido());
            stmt.setString(4, usuario.getClave());
            
            // Conversion para fecha 
            java.util.Date utilDate = usuario.getFechanacimiento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            stmt.setDate(5, sqlDate);
            stmt.setInt(6, usuario.getActivo());
            
            // Declarar Rol
            Rol rol = new Rol();
            // instancia un objeto de la Clase Rol, le da el parametro que almaceno el usuario
            // lo convierte a Clase ROL
            rol = usuario.getRol();
            // envia dato de clase Rol
            stmt.setInt(7, rol.getId());
            
            stmt.executeUpdate();
            
            
            System.out.println("Agrego");
            creo = true;
            System.out.println("resultado Boolean " + creo);
            
        } catch (Exception ex) {
            System.out.println("No agrego");
             Logger.getLogger(UsuarioDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        System.out.println("resultado Boolean " + creo);
        return creo;
        
    
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Usuario usuario) {
      
        boolean elimino = false;
        
        try {

            String querySQLEliminar = "DELETE FROM usuario WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(querySQLEliminar);
            
            statement.setString(1, usuario.getEmail());
            
            statement.executeUpdate();
            System.out.println("Se elimino usuario");
            elimino = true;
            
        } catch (SQLException ex) {
            System.out.println("No elimino");
            Logger.getLogger(UsuarioDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return elimino;
        
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
    
        List<Usuario> listaU = new ArrayList<>();
       // String querySQL = " SELECT *FROM usuario";
        String querySQL = " SELECT usuario.email, usuario.nombre, usuario.apellido, "
                + "usuario.clave, usuario.fecha_nacimiento, usuario.activo, "
                + "rol.nombre AS nombre_rol FROM usuario"
                + " INNER JOIN rol ON usuario.rol = rol.id ";
        
        
        try {
            
            Statement statement = connection.createStatement();
            statement.execute(querySQL);
            ResultSet resultSet = statement.getResultSet();
            Usuario usuario;
            Rol rol;
            
             while(resultSet.next()) {
                usuario = new Usuario();
                rol = new Rol();
                usuario.setEmail(resultSet.getString("usuario.email"));
                usuario.setNombre(resultSet.getString("usuario.nombre"));
                usuario.setApellido(resultSet.getString("usuario.apellido"));
                usuario.setClave(resultSet.getString("usuario.clave"));
                usuario.setFechanacimiento(resultSet.getDate("usuario.fecha_nacimiento"));
                usuario.setActivo(resultSet.getInt("usuario.activo"));
                rol.setNombre(resultSet.getString("nombre_rol"));
                usuario.setRol(rol);
                
               // System.out.println("Lista");
                
                listaU.add(usuario);
            }
            
            
        } catch (Exception ex) {
             System.out.println("ERROR CONSULTA QUERY: " + ex.getMessage());System.out.println("No listo");
      
        }
        
        return listaU;
    }

    @Override
    public List<Usuario> listarFiltroEmail(Usuario usuario) {
        
            List<Usuario> listaCFE = new ArrayList<>();
            String consulta = " SELECT usuario.email, usuario.nombre, usuario.apellido, "
                + "usuario.clave, usuario.fecha_nacimiento, usuario.activo, "
                + "rol.nombre AS nombre_rol FROM usuario"
                + " INNER JOIN rol ON usuario.rol = rol.id "
                + " WHERE usuario.email = ?";
            
            
        try {    
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, usuario.getEmail());
            
           // statement.execute(consulta);
            ResultSet resultSet = statement.executeQuery();
            Rol rol;
            
            while(resultSet.next()){
                usuario = new Usuario();
                rol = new Rol();
                usuario.setEmail(resultSet.getString("usuario.email"));
                usuario.setNombre(resultSet.getString("usuario.nombre"));
                usuario.setApellido(resultSet.getString("usuario.apellido"));
                usuario.setClave(resultSet.getString("usuario.clave"));
                usuario.setFechanacimiento(resultSet.getDate("usuario.fecha_nacimiento"));
                usuario.setActivo(resultSet.getInt("usuario.activo"));
                rol.setNombre(resultSet.getString("nombre_rol"));
                usuario.setRol(rol);
                
                
            //    System.out.println("Usuario Rescatado: "+ usuario.toString());
                
            //   System.out.println("Lista Usuarios por email");
                
                listaCFE.add(usuario);
                
            }
                
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No Ejecuto la consulta listar por email");
        }
        
        return listaCFE;
     }
       
  
}
