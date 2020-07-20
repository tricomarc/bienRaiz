<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>            
         

<body>
    <div class="container" id="advanced-search-form">
         <h1>Mantenedor > Agregar Usuario</h1>
         <br>
        <h2>Nuevo Usuario</h2>

      
            
            <span class="error" >
                
                <c:if test="${not empty alerta}">
                    <b> 
                <c:out value="${alerta}" escapeXml="true" />
                <a href="${urlMantenedorUsuario}">Volver al Mantenedor </a>
                </b>
                </c:if>
                
            </span>
        
        
        
           <!-- Esta ruta - urlAgregarUsuario - la declare en el Header   -->
          <form action="${urlAgregarUsuario}" method="POST" id="frmEliminar"> 
                
                <div class="form-group2">
                    <label>Email</label>
                    <input type="text" name="txt_email" id="txt_email" class="form-control"  >
                </div>

                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="txt_nombre" id="txt_nombre" class="form-control" value="" >
                </div>
                <div class="form-group">
                    <label >Apellido</label>
                    <input type="text" name="txt_apellido" id="txt_apellido" class=" form-control" value=""  >
                </div>
              
              <div class="form-group">
                    <label >Clave</label>
                    <input type="text" name="txt_clave" id="txt_clave" class=" form-control" value=""  >
                </div>
              
                <div class="form-group">
                    <label >Fecha de Nacimiento</label>
                    <input type="date" name="txt_fecha_nac" id="txt_fecha_nac" class="form-control" value=""  >
                </div>

                <div class="form-group">
                    <label >Activo</label>
                   <select name="cmb_activo" id="cmb_activo"  class="form-control"  required="" >
                    <option value="1">SI</option>
                    <option value="2" >NO</option>
                    </select>
                </div>
              
               
                   
                <div class="form-group">
                   <label >Rol</label>
                  
                    <select name="cmb_rol" id="${r.id}"  class="form-control"  required="" >
                     <c:forEach items="${listaR}" var="r" >
                         <option value="${r.id}"><c:out value="${r.nombre}" escapeXml="true" /> </option>
                     </c:forEach> 
                    </select>
                   
               </div>    
                
              
                
                <div class="form-group">
                    <button type="submit" name="btn_agregar" id="btn_agregar" class="btn btn-info btn-lg btn-responsive" > <span class="glyphicon glyphicon-plus-sign"></span> Agregar</button>
               </div>

                <div class="form-group">
                <a href="${urlMantenedorUsuario}" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>
                </div>
            
                 
                
        </form>
    </div>
                
                <h4>TABLA ROL</h4>
                
                <table class="table table-bordered"> 
                <thead>
                    <tr>
                        <th>id</th>
                        <th>nombre</th>
                        <th>descripcion</th>
                                           </tr>
                </thead>
                
                <tbody>
                 <c:forEach items="${listaR}" var="r" >
                    <tr>
                   
                        <td><c:out value="${r.id}" escapeXml="true" /></td>
                        <td><c:out value="${r.nombre}" escapeXml="true" /></td>
                        <td><c:out value="${r.descripcion}" escapeXml="true" /></td>
                        
                    </tr>
                  </c:forEach> 
                    
                </tbody>
            </table>
                


<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  
