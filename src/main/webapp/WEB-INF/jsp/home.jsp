<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  		<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>		
	
  		<script type="text/javascript" class="init">	
	  		$(document).ready(function() {
//   			https://editor.datatables.net/examples/simple/multiRow.html
// 				view-source:https://editor.datatables.net/examples/simple/multiRow.html
  			
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
		<div class="upcon">
<!-- 	    	<img src="http://s2.subirimagenes.com/privadas/previo/thump_2404224sistema-de-clientes.jpg" style="width:100%" /> -->
	    	<img src="/clientes-abm/resources/img/home-header.jpg" style="width:100%"/>
		</div>
		<div class="container-fluid">
			<div class="container">
				<br>
				<br>
				<spring:url value="/Agregar Cliente" var="addUrl" />
				<spring:url value="/Editar Cliente/" var="editUrl" />
				
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

