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
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
				
  		<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>

  		<script type="text/javascript">	
  			$(document).ready( function () {
    			$('#clientes').DataTable();
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
	<body>
		<div class="container-fluid">
		<h1 align="center">Lista de clientes de Eduardo Felitti</h1>
			<div class="container">
				<br>
				<br>
				<spring:url value="/Agregar Cliente" var="addUrl" />
				<spring:url value="/Editar Cliente/" var="editUrl" />
				
				<button name="button" class="btn btn-default" onclick="location.href='${addUrl}'">Agregar Cliente</button>
				<br>
				<br>
				<table class="table table-bordered" class="display" id="clientes">
					<thead>
						<tr>
	        			<th>Nombre y Apellido</th>
	       				<th>Telefono</th>
	      				<th>Direccion</th>
	      				<th>Establecimiento</th>
	      				<th>Accion</th>	      				
	      				</tr>
	    			</thead>
	    			<tbody>
		    			<c:forEach var="Cliente" items="${Lista}">
		    				<tr>
		    					<td>${Cliente.nombreApellido}</td>
		    					<td>${Cliente.telefono}</td>
		    					<td>${Cliente.direccion}</td>
		    					<td>${Cliente.establecimiento}</td>
		    					<td>
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

