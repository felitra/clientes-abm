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
		<link rel="stylesheet" href="${resources}/css/utils.css" type="text/css">
				
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
			    
			    $('#buttonUpdate').click(function(event){
			    	
			    	var url = '${restBaseUrl}/',
			    		id = $('#id').val(),
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    	
			    	url += id;
			    				    	
			    	return jQuery.ajax({
			    	    headers: { 
			    	        'Accept': 'application/json',
			    	        'Content-Type': 'application/json' 
			    	    },
			    	    'type': 'PATCH',
			    	    'url': url,
			    	    'data' : JSON.stringify({
			    	    	nombreApellido: nomApe,
				        	telefono: tel,
				        	direccion: dire,
				        	establecimiento: est
						}),
			    	    'dataType': 'json',
			    	    'success': alert( "Cliente actualizado exitosamente!" ),
			    	    'error': alert("Error actualizando cliente, intente mas tarde")
			    	     
			    	    });
			    });
			    
			    $('#buttonClear').click(function(event){
			    	$('#nombreApellido').val('');
			    	$('#telefono').val('');
			    	$('#direccion').val('');
			    	$('#establecimiento').val('');
			    });
			    
			    $('#banner').click(function(event){
			    	window.location.replace('${baseUrl}');
			    });
			    
			    setupPage();
			});
			
			function setupPage(){
	  			var pathName = window.location.pathname;
	  			
	  			if (pathName.indexOf("update") >= 0){
	  					  				
	  				$('#id').val('${Cliente.id}');
	  				$('#nombreApellido').val('${Cliente.nombreApellido}');
			    	$('#telefono').val('${Cliente.telefono}');
			    	$('#direccion').val('${Cliente.direccion}');
			    	$('#establecimiento').val('${Cliente.establecimiento}');
			    	
			    	$("#buttonUpdate").removeClass("hidden");
	  			} else{
	  				$("#buttonCrear").removeClass("hidden");
	  			}
			}
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
						<input type="text" class="form-control hidden" id="id">
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
				<input id="buttonCrear" type="submit" class="btn btn-default hidden" value="Agregar Cliente"/>
				<input id="buttonUpdate" type="submit" class="btn btn-default hidden" value="Actualizar Cliente"/>
				<input id="buttonClear" type="submit" class="btn btn-default" value="Limpiar campos"/>
			</div>
		</div>
	</body>
</html>