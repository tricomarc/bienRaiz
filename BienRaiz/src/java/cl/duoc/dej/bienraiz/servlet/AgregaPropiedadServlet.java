/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import cl.duoc.dej.bienraiz.dao.BienRaizDAO;
import cl.duoc.dej.bienraiz.dao.TipoPropiedadDAO;
import cl.duoc.dej.bienraiz.dao.impl.BienRaizDAOJdbcImpl;
import cl.duoc.dej.bienraiz.dao.impl.TipoPropiedadDAOJdbcImpl;
import cl.duoc.dej.bienraiz.model.BienRaiz;
import cl.duoc.dej.bienraiz.model.Comuna;
import cl.duoc.dej.bienraiz.model.TipoPropiedad;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
public class AgregaPropiedadServlet extends HttpServlet {
    
    @Resource (name="jdbc/bienraizDS")
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
        request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarPropiedad.jsp").forward(request, response);
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
//        processRequest(request, response);
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
        String txt_titulo = request.getParameter("txt_titulo");
        String txt_descripción = request.getParameter("txt_descripción");
        String txt_direccion = request.getParameter("txt_direccion");
        String cmb_comuna =  request.getParameter("cmb_comuna");
        String cmb_tipo_propiedad = request.getParameter("cmb_tipo_propiedad");
        String txt_metros_cuadrados = request.getParameter("txt_metros_cuadrados");
        String txt_cantidad_dormitorios = request.getParameter("txt_cantidad_dormitorios");
        String txt_cantidad_banios = request.getParameter("txt_cantidad_banios");
        String txt_otros = request.getParameter("txt_otros");
        String txt_coordenada_latitud = request.getParameter("txt_coordenada_latitud");
        String txt_coordenada_longitud = request.getParameter("txt_coordenada_longitud");
        
        System.out.println("Id valor: " + txt_id_propiedad);
        System.out.println("Título valor: " + txt_titulo);
        System.out.println("Descripción valor: " + txt_descripción);
        System.out.println("Dirección valor: " + txt_direccion);
        System.out.println("Comuna  valor: " + cmb_comuna);
        System.out.println("Tipo Propiedad valor: " + cmb_tipo_propiedad);
        System.out.println("Metros Cuadrados valor: " + txt_metros_cuadrados);
        System.out.println("Cantidad Dormitorios valor: " + txt_cantidad_dormitorios);
        System.out.println("Cantidad Baños valor: " + txt_cantidad_banios);
        System.out.println("Otros valor :" + txt_otros);
        System.out.println("Coordenada Latitud valor: " + txt_coordenada_latitud);
        System.out.println("Coordenada Longitud valor: " + txt_coordenada_longitud);
        
        try {
            Connection connection = dataSource.getConnection();
            BienRaizDAO tdao = new BienRaizDAOJdbcImpl(connection);
            BienRaiz br = new BienRaiz();
            TipoPropiedad tp = new TipoPropiedad();
            Comuna c = new Comuna();
            
            br.setId(Integer.parseInt(txt_id_propiedad));
            br.setTitulo(txt_titulo);
            br.setDescripcion(txt_descripción);
            br.setDireccion(txt_direccion);
            c.setId(Integer.parseInt(cmb_comuna));
            tp.setId(Integer.parseInt(cmb_tipo_propiedad));
            br.setMetros_cuadrados(Integer.parseInt(txt_metros_cuadrados));
            br.setCantidad_dormitorios(Integer.parseInt(txt_cantidad_dormitorios));
            br.setCantidad_banios(Integer.parseInt(txt_cantidad_banios));
            br.setOtros(txt_otros);
            br.setCoordenada_latitud(Float.parseFloat(txt_coordenada_latitud));
            br.setCoordenada_longitud(Float.parseFloat(txt_coordenada_longitud));
            br.setId_comuna(c);
            br.setTipo_propiedad(tp);
            
            if (tdao.agregar(br)) {
                request.setAttribute("alerta","Se agrego propiedad");
            }else{
                request.setAttribute("alerta", "No se agrego Propiedad, codigo esta creado o datos ingresados erroneos");
            }
            request.getRequestDispatcher("/WEB-INF/jsp/privado/agregarPropiedad.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(MantenedorPropiedadesServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en agregar: " + ex.getMessage());
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
