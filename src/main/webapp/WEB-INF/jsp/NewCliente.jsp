<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Home</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<spring:url var="resources" value="/resources"/>		
						
		<link rel="stylesheet" href="${resources}/css/bootstrap.min.css" type="text/css">		
		<link rel="stylesheet" href="${resources}/css/jquery.dataTables.css" type="text/css">

		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
  		<script src="${resources}/js/jquery.dataTables.js" type="text/javascript" charset="utf8"></script>		
		
		<script type="text/javascript">	
	  		function addCliente(nombreApellido, telefono, direccion, establecimiento){
				    var form = document.createElement("form");
				    
				    //TODO: Investigar como mandar post con jquery	    
				    form.setAttribute("method", 'post');
		  		  	form.submit();
			    	return true;
			}
  		</script>
	</head>
	<body>
		<spring:url value="/rest/cliente" var="restBaseUrl" />
	
		<div class="container-fluid">
		<h1 align="center">Alta de Cliente</h1>
			<div class="container">
				<form:form method="POST" action="${restBaseUrl}">
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