<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>        

 <h1>PAGINA MANTENEDOR USUARIO</h1>
     <form  action="${urlMantenedorUsuario}" method="POST" id="frmMantenedor">
            <h3>Usuarios</h3>
            
            
            <table class="table table-bordered"> 
                <thead>
                    <tr>
                        <th>Email</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Activo</th>
                        <th>Rol</th>
                        <th>Acciónn</th>
                    </tr>
                </thead>
                
                <tbody>
                <c:forEach items="${listaU}" var="p" >
                    <tr>
                   
                        <td><c:out value="${p.email}" escapeXml="true" /></td>
                        <td><c:out value="${p.nombre}" escapeXml="true" /></td>
                        <td><c:out value="${p.apellido}" escapeXml="true" /></td>
                        <td><c:out value="${p.fechanacimiento}" escapeXml="true" /></td>
                        <td><c:out value="${p.activo}" escapeXml="true" /></td>
                        <td><c:out value="${p.rol.nombre}" escapeXml="true" /></td>
                        <td> <a href="${urlEliminarUsuario}?id=${p.email}">[Eliminar]</a> </td>
                    </tr>
                  </c:forEach> 
                    
                </tbody>
            </table>
            
        <div class="form-group ">
            <input type="submit"  name="btn_agregarU" id="btn_agregarU" name="submit" value="Agregar" class="btn btn-info" />
        </div>
    </form>
   
<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  