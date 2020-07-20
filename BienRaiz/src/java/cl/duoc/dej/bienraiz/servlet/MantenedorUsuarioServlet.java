/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.RolDAO;
import cl.duoc.dej.bienraiz.dao.UsuarioDAO;
import cl.duoc.dej.bienraiz.dao.impl.RolDAOJdbcImpl;
import cl.duoc.dej.bienraiz.dao.impl.UsuarioDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.Rol;
import cl.duoc.dej.bienraiz.model.Usuario;
import com.sun.xml.rpc.tools.wscompile.UsageIf;
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

/**
 *
 * @author Raniela
 */
public class MantenedorUsuarioServlet extends HttpServlet {

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
         request.getRequestDispatcher("/WEB-INF/jsp/privado/mantenedorUsuario.jsp").forward(request, response);
    
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
       
             
        try {
            Connection connection = dataSource.getConnection();
            UsuarioDAO dao = new UsuarioDAOJdbcImpl(connection);
            List<Usuario> usuarios = dao.listar();
            request.setAttribute("listaU",usuarios);
            request.getRequestDispatcher("/WEB-INF/jsp/privado/mantenedorUsuario.jsp").forward(request, response);
    
           // System.out.println("Conecta ");
        } catch (SQLException ex) {
            Logger.getLogger(MantenedorUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
            
        
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
       
        
        try {
            Connection connection = dataSource.getConnection();
            RolDAO rdao = new RolDAOJdbcImpl(connection);
            List<Rol> roles = rdao.listar();
            
            request.setAttribute("listaR",roles);
        //    request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarUsuario.jsp").forward(request, response);
    
            System.out.println("Lista");
              } catch (SQLException ex) {
            Logger.getLogger(MantenedorUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR LISTADO DE ROLES: " + ex.getMessage());
        }
        
        request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarUsuario.jsp").forward(request, response);
       
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
