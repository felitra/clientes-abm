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
		<h1 align="center">Alta de Cliente</h1>
			<div class="container">
				<form:form method="POST" action="/clientes-abm/Agregar Cliente">
					<div class="form-group">
		  				<label for="usr">Nombre y Apellido:</label>
		  				<input type="text" class="form-control" name="nombreApellido">
		  				<br>
		  				<label for="usr">Telefono:</label>
		  				<input type="text" class="form-control" name="telefono">
		  				<br>
		  				<label for="usr">Direccion:</label>
		  				<input type="text" class="form-control" name="direccion">
		  				<br>
		  				<label for="usr">Establecimiento:</label>
		  				<input type="text" class="form-control" name="establecimiento">
					</div>
					<input name="button" type="submit" class="btn btn-default" value="Agregar Cliente"/>
				</form:form>
			</div>
		</div>
	</body>
</html>