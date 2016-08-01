<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<h2>Bordered Table</h2>
				<p>The .table-bordered class adds borders to a table:</p>
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
	    			<c:forEach var="Cliente" items="Lista">
	    				<tr>
	    					<td>${Cliente.nombre}</td>
	    					<td>${Cliente.apellido}</td>
	    					<td>${Cliente.telefono}</td>
	    					<td>${Cliente.direccion}</td>
	    					<td>${Cliente.establecimiento}</td>
	    				</tr>
	    			</c:forEach>
	    			<tbody>
		      			<tr>
					        <td>John</td>
					        <td>Doe</td>
					        <td>telefono</td>
					        <td>direccion</td>
					        <td>establecimiento</td>
					        <td></td>
	      				</tr>
	    			</tbody>
	  			</table>
			</div>
		</div>
	</body>
</html>