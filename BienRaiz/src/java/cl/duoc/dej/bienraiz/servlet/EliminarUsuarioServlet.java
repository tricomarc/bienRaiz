/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.UsuarioDAO;
import cl.duoc.dej.bienraiz.dao.impl.UsuarioDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class EliminarUsuarioServlet extends HttpServlet {

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
       
          request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarUsuario.jsp").forward(request, response);
        
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
        
        String recEmail = request.getParameter("id");
        try {
            Connection connection = dataSource.getConnection();
            UsuarioDAO udao = new UsuarioDAOJdbcImpl(connection);
            Usuario usuario = new Usuario();
            usuario.setEmail(recEmail);
           // System.out.println("Email Recibido: " + recEmail);
            
            List<Usuario> usuarios = udao.listarFiltroEmail(usuario);
            request.setAttribute("listaCFE",usuarios);
             request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarUsuario.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println("Se cayo el eliminar :(");
            Logger.getLogger(EliminarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      // processRequest(request, response);
        
        
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
        System.out.println("Usuario a eliminar con correo: " + txt_email);
   
         try {
            Connection connection = dataSource.getConnection();
            UsuarioDAO udao = new UsuarioDAOJdbcImpl(connection);
            Usuario usuario = new Usuario();
            
            usuario.setEmail(txt_email);
            
            udao.eliminar(usuario);
            request.setAttribute("alerta", "Se elimino usuario");
            
            request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarUsuario.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println("Se cayo el eliminar :(");
            Logger.getLogger(EliminarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
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
