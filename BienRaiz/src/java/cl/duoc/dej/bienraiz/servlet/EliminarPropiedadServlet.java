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
 * @author mlazo
 */
public class EliminarPropiedadServlet extends HttpServlet {
    @Resource(name="jdbc/bienraizDS")
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
            request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarPropiedad.jsp").forward(request, response);
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
        String recId = request.getParameter("id");
        
        try {
            Connection connection = dataSource.getConnection();
            BienRaizDAO bdao = new BienRaizDAOJdbcImpl(connection);
            BienRaiz br = new BienRaiz();
            br.setId(Integer.parseInt(recId));
            List<BienRaiz> bienRaiz = bdao.listarID(br);
            request.setAttribute("listaID", bienRaiz);
            request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarPropiedad.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println("Se cae");
            Logger.getLogger(EliminarPropiedadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        String txt_id_propiedad = request.getParameter("txt_id_propiedad");
        System.out.println("Propiedad a eliminar con ID: " + txt_id_propiedad);
        
        try {
            Connection connection = dataSource.getConnection();
            BienRaizDAO bdao = new BienRaizDAOJdbcImpl(connection);
            BienRaiz bienRaiz = new BienRaiz();
            
            bienRaiz.setId(Integer.parseInt(txt_id_propiedad));
            bdao.eliminar(bienRaiz);
            request.setAttribute("alerta", "Se elimino propiedad");
            request.getRequestDispatcher("/WEB-INF/jsp/privado/eliminarPropiedad.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            System.out.println("Se cae al eliminar");
            Logger.getLogger(EliminarPropiedadServlet.class.getName()).log(Level.SEVERE, null, ex);
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
