/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.BienRaizDAO;
import cl.duoc.dej.bienraiz.dao.impl.BienRaizDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.BienRaiz;
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
public class ListarPropiedadesServlet extends HttpServlet {

   
    //Se instancia conexion a base de datos
    @Resource(name="jdbc/bienraizDS")
    //Recibe la conexión        
    DataSource dataSource;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/publico/propiedades.jsp").forward(request, response);
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
        // carga la lista completa
        Connection connection;
        try {
            connection = dataSource.getConnection();
        
        System.out.println("Conecta");
    //    Connection connection = ConexionManager.getInstance().getConexion();
        BienRaizDAO dao = new BienRaizDAOJdbcImpl(connection);
        List<BienRaiz> propiedades = dao.listar();
        request.setAttribute("lista",propiedades);
        request.getRequestDispatcher("/WEB-INF/jsp/publico/propiedades.jsp").forward(request, response);
        
        } catch (Exception ex) {
      //  Logger.getLogger(ListarPropiedadesServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No lista");  
    //  System.out.println("ERROR: " + ex.getMessage());
        
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
    
    }
        
        

}
