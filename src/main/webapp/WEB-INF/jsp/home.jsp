<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container-fluid">
		<h1 align="center">Lista de clientes de Eduardo Felitti</h1>
			<div class="container">
				<br>
				<br>
				<form:form method="GET" action="/clientes-abm/Agregar Cliente">
				<input name="button" type="submit" class="btn btn-default" value="Agregar Cliente"/>
				</form:form>
				<br>
				<br>
				<table class="table table-bordered">
					<thead>
						<tr>
	        			<th>Nombre</th>
	        			<th>Apellido</th>
	       				<th>Telefono</th>
	      				<th>Direccion</th>
	      				<th>Establecimiento</th>
<!-- 	      				<th>Accion</th>	      				 -->
	      				</tr>
	    			</thead>
	    			<c:forEach var="Cliente" items="${Lista}">
	    				<tr>
	    					<td>${Cliente.nombre}</td>
	    					<td>${Cliente.apellido}</td>
	    					<td>${Cliente.telefono}</td>
	    					<td>${Cliente.direccion}</td>
	    					<td>${Cliente.establecimiento}</td>
	    				</tr>
	    			</c:forEach>
	  			</table>
			</div>
		</div>
	</body>
</html>