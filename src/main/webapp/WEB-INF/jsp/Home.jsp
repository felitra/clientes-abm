<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<spring:url var="bootstrapCss" value="/resources/css/bootstrap.min.css"/>
		<spring:url var="dataTablesCss" value="/resources/css/jquery.dataTables.css"/>
		<spring:url var="jqueryMinJs" value="/resources/js/jquery.min.js"/>
		<spring:url var="dataTablesJs" value="/resources/js/jquery.dataTables.js"/>
				
		<link rel="stylesheet" href="${bootstrapCss}">
		<link rel="stylesheet" type="text/css" href="${dataTablesCss}">

		<script src="${jqueryMinJs}"></script>
  		<script type="text/javascript" charset="utf8" src="${dataTablesJs}"></script>		
	
  		<script type="text/javascript" class="init">	
	  		$(document).ready(function() {  			
  		        $('#clientes').dataTable( {
  		            language: {
  		                search: "Buscar cliente:",
  		              	emptyTable: "No hay clientes",
  			            paginate: {
	  		                previous:   "Previo",
	  		                next:       "Siguiente"
  		            	},
  		            	info: "Mostrando de _START_ a _END_ clientes de los _TOTAL_ totales",
  		            	lengthMenu: "Mostrar _MENU_ resultados"
  		            }
  		        } );
  		    } );
  		</script>
  		
		<script type="text/javascript">	
	  		function confirmDelete(id, nombreApellido){
				var x = confirm("Esta seguro que desea borrar al cliente: " + nombreApellido + " ?");
				if (x){
				    var form = document.createElement("form");
				    form.setAttribute("method", 'post');
		  		    form.setAttribute("action", 'delete/' + id);
		  		  	form.submit();
			    	return true;
				} else {
			    	return false;
	  			}
			}
  		</script>

</head>
	<body style="background-color:menu; ">
		
<%-- 	To resolve properties use:	<spring:eval var="variable" expression="@environment.getProperty('property')" /> --%>
		<spring:url  var="homeHeader" value="/resources/images/home-header.jpg"/>
		<spring:url value="/Agregar Cliente" var="addUrl" />
		<spring:url value="/Editar Cliente/" var="editUrl" />
				
		<div class="upcon">
	    	<img src="${homeHeader}" style="width:100%"/>
		</div>
		<div class="container-fluid">
			<div class="container">
				<br>
				<br>		
				<button name="button" class="btn btn-default" onclick="location.href='${addUrl}'">Agregar Cliente</button>
				<br>
				<br>
				<table  class="display compact cell-border" id="clientes">
					<thead>
						<tr>
	        			<th>Nombre y Apellido</th>
	       				<th>Teléfono</th>
	      				<th>Dirección</th>
	      				<th>Establecimiento</th>
	      				<th>Acción</th>	      				
	      				</tr>
	    			</thead>
	    			<tbody>
		    			<c:forEach var="Cliente" items="${Lista}">
		    				<tr>
		    					<td align="center">${Cliente.nombreApellido}</td>
		    					<td align="center">${Cliente.telefono}</td>
		    					<td align="center">${Cliente.direccion}</td>
		    					<td align="center">${Cliente.establecimiento}</td>
		    					<td align="center">
		    						<button class="btn btn-primary" style="width: 3cm;" id="editar" onclick="location.href='${editUrl}${Cliente.id}'">Editar</button>
		    						<br>
		    						<br>
				  					<button class="btn btn-danger" style="width: 3cm;" id="borrar" onclick="confirmDelete(${Cliente.id}, '${Cliente.nombreApellido}')">Eliminar</button>
                            	</td>
                            </tr>
		    			</c:forEach>
	    			</tbody>
	  			</table>
			</div>
		</div>
	</body>	
</html>

