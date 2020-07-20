/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.BienRaizDAO;
import cl.duoc.dej.bienraiz.dao.ComunaDAO;
import cl.duoc.dej.bienraiz.dao.TipoPropiedadDAO;
import cl.duoc.dej.bienraiz.dao.impl.BienRaizDAOJdbcImpl;
import cl.duoc.dej.bienraiz.dao.impl.ComunaDAOJdbcImpl;
import cl.duoc.dej.bienraiz.dao.impl.TipoPropiedadDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.BienRaiz;
import cl.duoc.dej.bienraiz.model.Comuna;
import cl.duoc.dej.bienraiz.model.TipoPropiedad;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mlazo
 */
public class MantenedorPropiedadesServlet extends HttpServlet {
     @Resource(name="jdbc/bienraizDS")
    //Recibe la conexión        
    javax.sql.DataSource dataSource;
    
            

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.2
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/jsp/privado/mantenedorPropiedades.jsp").forward(request, response);
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
             BienRaizDAO dao = new BienRaizDAOJdbcImpl(connection);
             List<BienRaiz> bienRaiz = dao.listar();
             request.setAttribute("lista", bienRaiz);
             request.getRequestDispatcher("/WEB-INF/jsp/privado/mantenedorPropiedades.jsp").forward(request, response);
         } catch (SQLException ex) {
             System.out.println("No lista");
             Logger.getLogger(MantenedorPropiedadesServlet.class.getName()).log(Level.SEVERE, null, ex);
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
             TipoPropiedadDAO tpdao = new TipoPropiedadDAOJdbcImpl(connection);
             List<TipoPropiedad> propiedad = tpdao.listar();
             ComunaDAO cdao = new ComunaDAOJdbcImpl(connection);
             List<Comuna> comuna = cdao.listar();
             request.setAttribute("listaC", comuna);
             request.setAttribute("listaTP", propiedad);
             
             System.out.println("Lista Marco");
         } catch (SQLException ex) {
             Logger.getLogger(MantenedorPropiedadesServlet.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Error listado:" + ex.getMessage());
         }
        request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarPropiedad.jsp").forward(request, response);
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
