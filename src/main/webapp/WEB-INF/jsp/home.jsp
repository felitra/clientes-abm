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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.css">
  		<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.js"></script>
  		<script type="text/javascript">	
  			$(document).ready( function () {
    			$('#clientes').DataTable();
			} );		
  		</script>
	</head>
	<body>
		<div class="container-fluid">
		<h1 align="center">Lista de clientes de Eduardo Felitti</h1>
			<div class="container">
				<br>
				<br>
<!-- 				Realizar este paso con form:form para unificar conceptos -->
				<spring:url value="/Agregar Cliente" var="addUrl" />
				<button name="button" class="btn btn-default" onclick="location.href='${addUrl}'">Agregar Cliente</button>
				<br>
				<br>
				<table class="table table-bordered" class="display" id="clientes">
					<thead>
						<tr>
						<th>ID</th>
	        			<th>Nombre</th>
	        			<th>Apellido</th>
	       				<th>Telefono</th>
	      				<th>Direccion</th>
	      				<th>Establecimiento</th>
	      				<th>Accion</th>	      				
	      				</tr>
	    			</thead>
	    			<tbody>
		    			<c:forEach var="Cliente" items="${Lista}">
		    				<tr>
		    					<td align="center">${Cliente.id}</td>
		    					<td>${Cliente.nombre}</td>
		    					<td>${Cliente.apellido}</td>
		    					<td>${Cliente.telefono}</td>
		    					<td>${Cliente.direccion}</td>
		    					<td>${Cliente.establecimiento}</td>
		    					<td>
									<form:form method="GET" action="Editar Cliente/${Cliente.id}">
				  					<button class="btn btn-primary">Editar</button>
				  					<button class="btn btn-danger" formmethod="post" formaction="delete/${Cliente.id}">Eliminar</button>
									</form:form>				
                            	</td>
                            </tr>
		    			</c:forEach>
	    			</tbody>
	  			</table>
			</div>
		</div>
	</body>
</html>

