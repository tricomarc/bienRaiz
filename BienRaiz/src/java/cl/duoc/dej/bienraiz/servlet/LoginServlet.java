/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej.bienraiz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Raniela
 */
public class LoginServlet extends HttpServlet {

     //Se instancia conexion a base de datos
  //  @Resource(name="jdbc/bienraizDS")
    //Recibe la conexión        
 //   DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/jsp/publico/login.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
      //  String vista = request.getRequestDispatcher("/WEB-INF/jsp/publico/login.jsp").forward(request, response)    

        if("admin".equals(usuario) && "admin".equals(clave)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", "Administrador");
            session.setAttribute("autenticado", true);        
            response.sendRedirect(request.getContextPath()+"/inicio");
      
        } else {
            request.setAttribute("error", "El usuario: "+usuario+" no se encuentra en el sistema");
             request.getRequestDispatcher("/WEB-INF/jsp/publico/login.jsp").forward(request, response);
        }     
        
    }
}
