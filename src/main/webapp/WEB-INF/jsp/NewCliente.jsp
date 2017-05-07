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
		<spring:url value="/rest/cliente" var="restBaseUrl" />
		<spring:url value="/" var="baseUrl" />
						
		<link rel="stylesheet" href="${resources}/css/bootstrap.min.css" type="text/css">		

		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
		
		
		<script type="text/javascript">
			$(document).ready(function(){
			    $('#buttonCrear').click(function(event){
			    				    	
			    	var url = '${restBaseUrl}',
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    				    	
			    	return jQuery.ajax({
			    	    headers: { 
			    	        'Accept': 'application/json',
			    	        'Content-Type': 'application/json' 
			    	    },
			    	    'type': 'POST',
			    	    'url': url,
			    	    'data' : JSON.stringify({
			    	    	nombreApellido: nomApe,
				        	telefono: tel,
				        	direccion: dire,
				        	establecimiento: est
						}),
			    	    'dataType': 'json',
			    	    'success': alert( "Cliente creado exitosamente!" )
			    	    });
			    });
			    
			    $('#buttonClear').click(function(event){
			    	$('#nombreApellido').val('');
			    	$('#telefono').val('');
			    	$('#direccion').val('');
			    	$('#establecimiento').val('');
			    });
			    
			    $('#banner').click(function(event){
			    	
			    	var url = '${baseUrl}';
			    	window.location.replace(url);
			    });
			});
  		</script>
	</head>
	<body style="background-color:menu; ">
		
		<div class="upcon">
	    	<img id="banner" src="${resources}/images/home-header.jpg" style="width:100%; cursor:pointer"/>
		</div>
		<br>
		<div class="container-fluid">
			<div class="container">
					<div class="form-group">
		  				<label for="usr">Nombre y Apellido:</label>
		  				<input type="text" class="form-control" id="nombreApellido">
		  				<br>
		  				<label for="usr">Telefono:</label>
		  				<input type="text" class="form-control" id="telefono">
		  				<br>
		  				<label for="usr">Direccion:</label>
		  				<input type="text" class="form-control" id="direccion">
		  				<br>
		  				<label for="usr">Establecimiento:</label>
		  				<input type="text" class="form-control" id="establecimiento">
					</div>
				<input id="buttonCrear" type="submit" class="btn btn-default" value="Agregar Cliente"/>
				<input id="buttonClear" type="submit" class="btn btn-default" value="Limpiar campos"/>
			</div>
		</div>
	</body>
</html>