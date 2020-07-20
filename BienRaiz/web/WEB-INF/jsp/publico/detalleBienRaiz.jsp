<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="urlInicio" value="/inicio"/>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>
<div class="container" id="advanced-search-form">
    <h2>Detalle Bien Raíz</h2>
    <form>
        <c:forEach items="${lista}" var="b">
            <div>
                <label>ID</label>
                <input type="text" name="txt_id" id="${b.id}" class="form-control" value="${b.id}" readonly="true">
            </div>
            <div>
                <label>Título</label>
                <input type="text" name="txt_titulo" id="${b.titulo}" value="${b.titulo}" readonly="true">
            </div>
            <div>
                <label>Dirección</label>
                <input type="text" name="txt_direccion" id="${b.descripcion}" value="${b.descripcion}"  readonly="true">
            </div>
            <div>
                <label>ID Comuna</label>
                <input type="text" name="txt_id_comuna" id="${b.comuna}"
            </div>
        </c:forEach>
    </form>
    
</di