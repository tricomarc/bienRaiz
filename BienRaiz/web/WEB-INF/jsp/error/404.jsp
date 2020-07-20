
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>         

<c:url var="urlImage404"   value="/img/404.gif"/>

<div class="error imagen">
    <h2>404  Página no encontrada</h2>
    <img src="${urlImage404}" />
</div>   
        
<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  