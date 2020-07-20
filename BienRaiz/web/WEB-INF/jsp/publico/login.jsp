

<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>       


            
<!Falta que muestre error por no logearse>

            <span class="error">
              
                <c:if test="${not empty error}">
                <c:out value="${error}" escapeXml="true" />
                </c:if>
                
            </span>
    
    <div class="container" id="log-in-form">
        <div class="heading">
            <h1>Login</h1>
        </div>
        <form action="${urlLogin}" method="POST">
            <div class="form-group">
                <input type="text" name="usuario" value="" class="form-control" placeholder="Usuario">
            </div>
            <div class="form-group">
                <input type="password" name="clave" value=""  class="form-control" placeholder="Clave">
            </div>
            <div class="form-group form-group-btn">
                <button type="submit" class="btn btn-primary">Acceder</button>
            </div>
            <div class="clearfix"></div>
           
        </form>
    </div>

            

<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  