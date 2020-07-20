<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>
<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>         

<c:url var="urlImage500"   value="/img/500.jpg"/>

<div >
    <h2>500 Error Interno del Servidor</h2>    
    <img src="${urlImage500}" />
    <div>
        <!--
        <b>Message</b>: 
        <p>
            <jsp:scriptlet> 
                exception.printStackTrace(new java.io.PrintWriter(out)); 
            </jsp:scriptlet>
        </p>
        -->
    </div>
</div>   
        
<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  