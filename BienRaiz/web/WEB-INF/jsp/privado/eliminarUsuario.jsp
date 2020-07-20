<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>            
         
<div class="container" id="advanced-search-form">
         <h4>Mantenedor > Eliminar Usuario</h4>
        
        <h2>Eliminar Usuario</h2>
        <form action="${urlEliminarUsuario}" method="POST" id="frmEliminar">
            
            <span class="error" >
                
                <c:if test="${not empty alerta}">
                    <b> 
                <c:out value="${alerta}" escapeXml="true" />
                <a href="${urlMantenedorUsuario}">Volver al Mantenedor </a>
                </b>
                </c:if>
                
            </span>
            
         
            <c:forEach items="${listaCFE}" var="p">  
                <div class="form-group2">
                    <label>Email</label>
                    <input type="text" name="txt_email" id="${p.email}" class="form-control" value="${p.email}" readonly="true" >
                </div>

                <div class="form-group">
                    <label>Nombre</label>
                    <input type="text" name="txt_nombre" id="${p.nombre}" class="form-control" value="${p.nombre}" readonly="true">
                </div>
                <div class="form-group">
                    <label >Apellido</label>
                    <input type="text" name="txt_apellido" id="${p.apellido}" class=" form-control" value="${p.apellido}"  readonly="true">
                </div>
                <div class="form-group">
                    <label >Fecha de Nacimiento</label>
                    <input type="date" name="txt_fecha_nac" id="${p.fechanacimiento}" class="form-control" value="${p.fechanacimiento}" readonly="true" >
                </div>

                <div class="form-group">
                    <label >Activo</label>
                    <input type="number" name="txt_activo" id="${p.activo}" class="form-control" value="${p.activo}" readonly="true">
                </div>
                <div class="form-group2">
                    <label >Rol</label>
                    <input type="text" name="txt_rol" id="${p.rol.nombre}" class="form-control" value="${p.rol.nombre}" readonly="true">
                </div>
               
                
                <div class="form-group">
                    <button type="submit" name="btn" id="btn_eliminar" class="btn btn-info btn-lg btn-responsive" > <span class="glyphicon glyphicon-trash"></span> Eliminar</button>
               </div>

                <div class="form-group">
                <a href="${urlMantenedorUsuario}" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>
                </div>
            
            </c:forEach>      
                
        </form>
    </div>








<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  
