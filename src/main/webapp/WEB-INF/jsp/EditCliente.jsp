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
		<h1 align="center">Edicion de Cliente</h1>
			<div class="container">
				<form:form method="POST" action="/clientes-abm/Editar Cliente">
					<div class="form-group">
						<label for="usr">ID:</label>
		  				<input type="text" class="form-control" name="id" value= "${Cliente.id}" readonly="readonly">
		  				<br>
		  				<label for="usr">Nombre:</label>
		  				<input type="text" class="form-control" name="nombre" value= "${Cliente.nombre}">
		  				<br>
		  				<label for="usr">Apellido:</label>
		  				<input type="text" class="form-control" name="apellido" value= "${Cliente.apellido}">
		  				<br>
		  				<label for="usr">Telefono:</label>
		  				<input type="text" class="form-control" name="telefono" value= "${Cliente.telefono}">
		  				<br>
		  				<label for="usr">Direccion:</label>
		  				<input type="text" class="form-control" name="direccion" value= "${Cliente.direccion}">
		  				<br>
		  				<label for="usr">Establecimiento:</label>
		  				<input type="text" class="form-control" name="establecimiento" value= "${Cliente.establecimiento}">
					</div>
					<input name="button" type="submit" class="btn btn-default" value="Confirmar cambios"/>
				</form:form>
			</div>
		</div>
	</body>
</html>