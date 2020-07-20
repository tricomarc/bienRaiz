<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="urlCssStyle"     value="/css/style.css"/>
<c:url var="urlCss"     value="/css/css.css"/>

<!Para que redirecione hay que ir al XML e ir a servlet-mapping y en url-pattern
    Se le da el valor que almacena "value">

<c:url var="urlLogin"   value="/login"/>
<c:url var="urlLogout"  value="/logout"/>

<c:url var="urlAgregar"     value="/agregar"/>
<c:url var="urlEliminar"     value="/eliminar"/>
<c:url var="urlDetalle"     value="/detallePropiedad"/>
<c:url var="urlMantenedorPropiedades"     value="/private/mantenedor-propiedades"/>
<c:url var="urlMantenedorUsuario" value="/private/mantenedor-usuario"/>
<c:url var="urlEliminarUsuario"     value="/private/eliminar-usuario"/>
<c:url var="urlEliminarPropiedad"     value="/private/eliminar-propiedad"/>
 <!-- Esta ruta - /private/agregar-usuario - es como se llamara el Servlet, 
 abreviacion, declarado en el XML, las declare aqui, para que la utilicen sin referenciarla
 más de una vez la ruta-->
<c:url var="urlAgregarUsuario"     value="/private/agregar-usuario"/>
<c:url var="urlAgregarPropiedad"     value="/private/agregar-propiedad"/>

<!DOCTYPE html>


<html lang="en">
<head>
<title>DEJ Propiedades Inmobiliarias</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="${urlCss}" rel="stylesheet" type="text/css" media="all"/>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${urlCssStyle}">

</head>
<body>

<header>
  
    <h1>
                <img class="banner imagen" src="img/logo.jpg" alt=""/>
                
                <h1 class="banner texto" >
                    DEJ Propiedades
                    </br>
                    Inmobiliarias
                </h1>
    </h1>
    
                <div class="login">
                  
                    <c:choose>
                        <c:when test="${autenticado}">
                            <a href="${urlLogout}">[Logout]</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${urlLogin}">[Login]</a>
                        </c:otherwise>
                    </c:choose>     
                    
                
                   
                </div>
    
   </header>

<div class="row">
  <div class="column side" style="background-color:#ffffff;"></div>
  
   
  
   <div class="column middle" style="background-color:#ffffff;">
       
       