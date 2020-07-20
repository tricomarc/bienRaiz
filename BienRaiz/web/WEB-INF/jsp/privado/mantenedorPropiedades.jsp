<%@taglib prefix="" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>

<H1>PAGINA MANTENEDOR PROPIEDAD</H1>
<form action="${urlMantenedorPropiedad}" method="POST" id="frmMantenedor">
    <h3>Propiedades</h3>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID Propiedad</th>
                <th>Título</th>
                <th>Descripción</th>
                <th>Dirección</th>
                <th>Id Comuna</th>
                <th>Tipo de Propiedad</th>
                <th>Metros Cuadrados</th>
                <th>Cantidad Dormitorios</th>
                <th>Cantidad Baños</th>
                <th>Otros</th>
                <th>Coordenada Latitud</th>
                <th>Coordenada Longitud</th>
                <th>Acciónn</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lista}" var="p">
                <tr>
                    <td><c:out value="${p.id}" escapeXml="true"/></td>
                    <td><c:out value="${p.titulo}" escapeXml="true"/></td>
                    <td><c:out value="${p.descripcion}" escapeXml="true"/></td>
                    <td><c:out value="${p.direccion}" escapeXml="true"/></td>
                    <td><c:out value="${p.id_comuna.nombre}" escapeXml="true"/></td>
                    <td><c:out value="${p.tipo_propiedad.nombre}" escapeXml="true"/></td>
                    <td><c:out value="${p.metros_cuadrados}" escapeXml="true"/></td>
                    <td><c:out value="${p.cantidad_dormitorios}" escapeXml="true"/></td>
                    <td><c:out value="${p.cantidad_banios}" escapeXml="true"/></td>
                    <td><c:out value="${p.otros}" escapeXml="true"/></td>
                    <td><c:out value="${p.coordenada_latitud}" escapeXml="true"/></td>
                    <td><c:out value="${p.coordenada_longitud}" escapeXml="true"/></td>
                    <td><a href="${urlEliminarPropiedad}?id=${p.id}">[Eliminar]</a></td>                     
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="form-group">
        <input type="submit" name="btn_agregar" id="btn_agregar" name="sumbit" value="Agregar" class="btn btn-info" />
    </div>
</form>

<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>