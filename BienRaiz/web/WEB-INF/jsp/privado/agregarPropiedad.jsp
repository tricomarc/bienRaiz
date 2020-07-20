<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>

<body>
<div class="container" id="advanced-search-form">
    <h2>Mantendor > Agregar Propiedad</h2>
    <br>
    <h3>Nueva Propiedad</h3>
    <span class="error">
        <c:if test="${not empty alerta}">
            <b>
        <c:out value="${alerta}" escapeXml="true"/>
        <a href="${urlMantenedorPropiedad}">Volver al Mantenedor</a>
            </b>
        </c:if>    
    </span>
    <form action="${urlAgregarPropiedad}" method="POST" id="frmEliminar">
        <div class="form-group2">
            <label>Id Propiedad</label>
            <input type="text" name="txt_id_propiedad" id="txt_id_propiedad" class="form-control">
        </div>
        <div class="form-group">
            <label>Titulo</label>
            <input type="text" name="txt_titulo" id="txt_titulo" class="form-control">
        </div>
        <div class="form-group">
            <label>Descripción</label>
            <input type="text" name="txt_descripción" id="txt_descripción" class="form-control">
        </div>
        <div class="form-group">
            <label>Dirección</label>
            <input type="text" name="txt_direccion" id="txt_direccion" class="form-control">
        </div>
        
        <div class="form-group">
            <label>Comuna</label>
            <!--<input type="text" name="txt_id_comuna" id="txt_id_comuna" class="form-control">-->
            <select name="cmb_comuna" id="${c.id}" class="form-control">
                <c:forEach items="${listaC}" var="c">
                    <option value="${c.id}"><c:out value="${c.nombre}" escapeXml="true" /></option>
                </c:forEach>
            </select>  
        </div>
                
        <div class="form-group">
            <label>Tipo Propiedad</label>
           <!-- <input type="text" name="txt_tipo_propiedad" id="txt_tipo_propiedad" class="form-control">-->
           <select name="cmb_tipo_propiedad" id="${t.id}" class="form-control" >
               <c:forEach items="${listaTP}" var="t">
                   <option value="${t.id}"><c:out value="${t.nombre}" escapeXml="true" /></option>
               </c:forEach>
           </select>
        </div>
        <div class="form-group">
            <label>Metros Cuadrados</label>
            <input type="text" name="txt_metros_cuadrados" id="txt_metros_cuadrados" class="form-control">
        </div>
        <div class="form-group">
            <label>Cantidad Dormitorios</label>
            <input type="text" name="txt_cantidad_dormitorios" id="txt_cantidad_dormitorios" class="form-control">
        </div>
        <div class="form-group">
            <label>Cantidad Baños</label>
            <input type="text" name="txt_cantidad_banios" id="txt_cantidad_banios" class="form-control">
        </div>
        <div class="form-group">
            <label>Otros</label>
            <input type="text" name="txt_otros" id="txt_otros" class="form-control">
        </div>
        <div class="form-group">
            <label>Coordenada Latitud</label>
            <input type="text" name="txt_coordenada_latitud" id="txt_coordenada_latitud" class="form-control">
        </div>
        <div class="form-group">
            <label>Coordenada Longitud</label>
            <input type="text" name="txt_coordenada_longitud" id="txt_coordenada_longitud" class="form-control">
        </div>    
        <div class="form-group">
            <button type="submit" name="btn_agregar" id="btn_agregar" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon glyphicon-plus-sign"></span>Agregar</button>
        </div>
        <div class="form-group">
            <a href="${urlMantenedorPropiedad}" class="btn btn-info btn-lg btn-responsive"><span class="glyphicon glyphicon-remove"></span>Cancelar</a>    
        </div>
    </form>
</div>
        
<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  