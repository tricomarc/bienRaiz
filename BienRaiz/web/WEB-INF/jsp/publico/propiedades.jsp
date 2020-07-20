<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="/WEB-INF/jsp/comun/header.jsp" %>
<%@include file="/WEB-INF/jsp/comun/menu.jsp" %>            
            
<h4> PAGINA DE LISTADO DE PROPIEDADES  </h4>


 
 
 
 <section>
     

            <h3>PROPIEDADES</h3>

             
             <div class="row">
                <div class="col-xs-3">
                    <h4>FILTRAR POR </h4>
                </div>
                 
                <div class="col-xs-3">
                   <select name="cmb_filtro" id="cmb_filtro"  class="form-control"  >
                     <option>Código de la Propiedad</option>
                     <option>Operación</option>
                     <option>Comuna</option>
                     <option>Tipo de propiedad</option>
                   </select>
                </div>
                 
                <div class="col-xs-3">
                   <input type="text" name="txt_dato_filtro" id="txt_dato_filtro" class=" form-control" placeholder="Ingrese dato a filtrar" required=""  >
                </div>
                 
                 <div class="col-xs-3">
                   
                        <button type="submit" name="btn_buscar" id="btn_buscar" class="btn btn-info" > <span class="glyphicon glyphicon-search"></span> Buscar</button>
                        <a href="${urlPropiedades}" class="btn btn-info" > <span class="glyphicon glyphicon-search"></span> Sin Filtros</a>
                        
                </div>
                 
            </div>
         
            
            
            <BR>
             <span class="error" >
                
                <c:if test="${not empty errorFiltros}">
                    <b> 
                <c:out value="${errorFiltros}" escapeXml="true" />
                </b>
                </c:if>
                
            </span>
            </br>
            
            <table class="table table-bordered"> 
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Titulo</th>
                        <th>Descripcion</th>
                        <th>Direccion</th>
                        <th>Id Comuna</th>
                        <th>Tipo Propiedad</th>
                        <th>Mts 2</th>
                        <th>Dorm.</th>
                        <th>Baños</th>
                        <th>Otros</th>
                        <th>Coordenada Latitud</th>
                        <th>Coordenada Longitud</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <!Esto es de prueba, hay que ingregsar codigo jstl>
                      <c:forEach items="${lista}" var="p" >
               
                    <tr>
                         
                        <td><c:out value="${p.id}" escapeXml="true" /></a></td>
                        <td><c:out value="${p.titulo}" escapeXml="true" /></td>
                        <td><c:out value="${p.descripcion}" escapeXml="true" /></td>
                        <td><c:out value="${p.direccion}" escapeXml="true" /></td>
                        <td><c:out value="${p.comuna.nombre}" escapeXml="true" /></td>
                        <td><c:out value="${p.tipo_propiedad.nombre}" escapeXml="true" /></td>
                        <td><c:out value="${p.metros_cuadrados}" escapeXml="true" /></td>
                        <td><c:out value="${p.cantidad_dormitorios}" escapeXml="true" /></td>
                        <td><c:out value="${p.cantidad_banios}" escapeXml="true" /></td>
                        <td><c:out value="${p.otros}" escapeXml="true" /></td>
                        <td><c:out value="${p.coordenada_latitud}" escapeXml="true" /></td>
                        <td><c:out value="${p.coordenada_longitud}" escapeXml="true" /></td>
                    </tr>
                    
                    </c:forEach>
                     <!Fin del Contenido>
                </tbody>
            </table>
            
        </section>
 
 

<%@include file="/WEB-INF/jsp/comun/footer.jsp" %>  
