<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %> 

<div class="container" id="advanced-search-form">
    <h4>Mantenedor > Eliminar Propiedad</h4>
    
    <h2>Eliminar Propiedad</h2>
    <form action="${urlEliminarPropiedad}" method="POST" id="frmEliminar">
        <span class="error">
        <c:if test="${not empty alerta}">
            <b>
                <c:out value="${alerta}" escapeXml="true"/>
                <a href="${urlMantenedorPropiedad}">Volver al Mantenedor</a>
            </b>    
        </c:if>
    </span>
    
    <c:forEach items="${listaID}" var="l">
        <div class="form-group2">
            <label>ID Propiedad</label>
            <input type="text" name="txt_id_propiedad" id="${l.id}" class="form-control" value="${l.id}" readonly="true">
        </div>
        <div class="form-group">
            <label>Descripción</label>
            <input type="text" name="txt_descripcion" id="${l.descripcion}" class="form-control" value="${l.descripcion}" readonly="true">
        </div>
        <div class="form-group">
            <label>Dirección</label>
            <input type="text" name="txt_direccion" id="${l.direccion}" class="form-control" value="${l.direccion}" readonly="true">
        </div>
        <div class="form-group">
            <label>Comuna</label>
            <input type="text" name="txt_comuna" id="${l.id_comuna.nombre}" class="form-control" value="${l.id_comuna.nombre}" readonly="true">            
        </div>
        <div class="form-group">
            <label>Tipo Propiedad</label>   
            <input type="text" name="txt_tipo_propiedad" id="${l.tipo_propiedad.nombre}" class="form-control" value="${l.tipo_propiedad.nombre}" readonly="true">
        </div>
        <div class="form-group">
            <label>Metros Cuadrados</label>
            <input type="text" name="txt_metros_cuadrados" id="${l.metros_cuadrados}" class="form-control" value="${l.metros_cuadrados}"readonly="true">
        </div>
        <div class="form-group">
            <label>Cantidad Dormitorios</label>
            <input type="text" name="txt_cantidad_dormitorios" id="${l.cantidad_dormitorios}" class="form-control" value="${l.cantidad_dormitorios}" readonly="true">
        </div>
        <div class="form-group">
            <label>Cantidad Baños</label>
            <input type="text" name="txt_cantidad_banios" id="${l.cantidad_banios}" class="form-control" value="${l.cantidad_banios}" readonly="true">
        </div>
        <div class="form-group">
            <label>Otros</label>
            <input type="text" name="txt_otro" id="${l.otros}" class="form-control"  value="${l.otros}" readonly="true">
        </div>
        <div class="form-group">
            <label>Coordenadas Latitud</label>
            <input type="text" name="txt_coordenada_latitud" id="${l.coordenada_latitud}" class="form-control" value="${l.coordenada_latitud}" readonly="true">
        </div>
        <div class="form-group">
            <label>Coordenadas Longitud</label>
            <input type="text" name="txt_coordenada_longitud" id="${l.coordenada_longitud}" class="form-control" value="${l.coordenada_longitud}" readonly="true">
        </div>
        <div class="form-group">
            <button type="submit" name="btn_eliminar" id="btn_eliminar" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon-remove"></span>Eliminar</button>
        </div>
        
        <div class="form-group">
            <a href="${urlMantenedorPropiedad}" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>
        </div>
    </c:forEach>
    </form>
</div>
        
        <%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  