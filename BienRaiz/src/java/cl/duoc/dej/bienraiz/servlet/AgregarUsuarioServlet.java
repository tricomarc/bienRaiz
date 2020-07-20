
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.RolDAO;
import cl.duoc.dej.bienraiz.dao.UsuarioDAO;
import cl.duoc.dej.bienraiz.dao.impl.RolDAOJdbcImpl;
import cl.duoc.dej.bienraiz.dao.impl.UsuarioDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.Rol;
import cl.duoc.dej.bienraiz.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class AgregarUsuarioServlet extends HttpServlet {

    //Se instancia conexion a base de datos
    @Resource(name="jdbc/bienraizDS")
    //Recibe la conexión        
    DataSource dataSource;
    
    
    
    
        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarUsuario.jsp").forward(request, response);
    
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
// ver porque no funciona
//             try {
//            Connection connection = dataSource.getConnection();
//            RolDAO rdao = new RolDAOJdbcImpl(connection);
//            List<Rol> roles = rdao.listar();
//            
//            request.setAttribute("listaR",roles);
//            request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarUsuario.jsp").forward(request, response);
//    
//            System.out.println("Lista");
//              } catch (SQLException ex) {
//            Logger.getLogger(MantenedorUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("ERROR LISTADO DE ROLES: " + ex.getMessage());
//        }
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        String txt_email = request.getParameter("txt_email");
        String txt_nombre =  request.getParameter("txt_nombre");
        String txt_apellido = request.getParameter("txt_apellido");
        String txt_clave = request.getParameter("txt_clave");
        String txt_fecha_nac = request.getParameter("txt_fecha_nac");
        String cmb_activo = request.getParameter("cmb_activo");
        String cmb_rol = request.getParameter("cmb_rol");
               
        System.out.println("Email Valor: " + txt_email);     
        System.out.println("Nombre Valor: " + txt_nombre);     
        System.out.println("Apellido Valor: " + txt_apellido);     
        System.out.println("Clave Valor: " + txt_clave);     
        System.out.println("Fecha Valor: " + txt_fecha_nac);     
        System.out.println("Activo Valor: " + cmb_activo);     
        System.out.println("Rol Valor: " + cmb_rol);      
        
        
        try {
            Connection connection = dataSource.getConnection();
            UsuarioDAO udao = new UsuarioDAOJdbcImpl(connection);
            Usuario usuario = new Usuario();
            Rol rol = new Rol();
            
            usuario.setEmail(txt_email);
            usuario.setNombre(txt_nombre);
            usuario.setApellido(txt_apellido);
            usuario.setClave(txt_clave);
            
            
            
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = formato.parse(txt_fecha_nac);
                System.out.println("Fecha Con Formato: " + fecha);
                usuario.setFechanacimiento(fecha);
            } catch (ParseException e){
                System.out.println("Error, la cadena de texto no se puede convertir en fecha.");
                    }
            usuario.setActivo(Integer.parseInt(cmb_activo));
            
            rol.setId(Integer.parseInt(cmb_rol));
            
            usuario.setRol(rol);
            
            if(udao.agregar(usuario)){
                request.setAttribute("alerta", "Se agrego Usuario");
            
            }else{
                request.setAttribute("alerta", "No se agrego Usuario, codigo ya esta creado o datos ingresados estan erroneos");
            }
            
            request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarUsuario.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenedorUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR EN AGREGAR: " + ex.getMessage());
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
