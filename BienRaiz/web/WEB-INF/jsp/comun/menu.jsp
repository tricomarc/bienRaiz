<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="urlContacto"   value="/contacto"/>
<c:url var="urlInicio"     value="/inicio"/>
<c:url var="urlPropiedades"  value="/listar-propiedades-servlet"/>
<c:url var="urlMantenedorPropiedad" value="/private/mantenedor-propiedades"/>
<c:url var="urlMantenedorUsuario" value="/private/mantenedor-usuario"/>


    <ul>
        <li>
            <a href="${urlInicio}">Inicio  |</a>
           
            <a href="${urlContacto}">Contacto  |</a>
            
            
            
            
            
        
             <c:if test="${autenticado}">
                
            <a href="${urlMantenedorPropiedad}">Mantenedor Propiedades  |</a>
            <a href="${urlMantenedorUsuario}">Mantenedor Usuarios</a>
            <!Falta condicion si esta logeado
            
            </c:if>                                             
            <!Falta condicion si esta logeado> 
        </li>
      
    </ul>
