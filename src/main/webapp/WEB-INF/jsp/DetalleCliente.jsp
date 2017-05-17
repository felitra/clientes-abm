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
		<link rel="stylesheet" href="${resources}/css/jquery-confirm.min.css" type="text/css">
				
		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.httpRequests.js" type="text/javascript" charset="utf8"></script>		
		<script src="${resources}/js/jquery-confirm.min.js" type="text/javascript" charset="utf8"></script>
			
		<script type="text/javascript">
			$(document).ready(function(){
			    $('#buttonCrear').click(function(event){
			    				    	
			    	var url = '${restBaseUrl}',
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    		
			    	addOrUpdateCliente(url, 'POST', nomApe, tel, dire, est);
			    });
			    
			    $('#buttonUpdate').click(function(event){
			    	
			    	var url = '${restBaseUrl}/',
			    		id = $('#id').val(),
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    	
			    	url += id;
			    	
			    	addOrUpdateCliente(url, 'PATCH', nomApe, tel, dire, est);
			    });
			    
			    $('#buttonClear').click(function(event){
			    	$('#nombreApellido').val('');
			    	$('#telefono').val('');
			    	$('#direccion').val('');
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
	  				$('#establecimiento').val('Casa');
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
			<div class="container content-size">
					<div class="form-group">
						<input type="text" class="form-control hidden" id="id">
						<br>
		  				<label for="nomape">Nombre y Apellido:</label>
		  				<input type="text" class="form-control" id="nombreApellido">
		  				<br>
		  				<label for="tel">Tel�fono:</label>
		  				<input type="text" class="form-control" id="telefono">
		  				<br>
		  				<label for="dire">Direcci�n:</label>
		  				<input type="text" class="form-control" id="direccion">
		  				<br>
		  				<label for="est">Establecimiento:</label>
		  				<input type="text" class="form-control" id="establecimiento">
		  				<br>
					</div>
					<button id="buttonCrear" class="btn btn-default hidden">
						<span class="glyphicon glyphicon-floppy-disk"></span> Agregar Cliente
					</button>
					<button id="buttonUpdate" class="btn btn-default hidden">
						<span class="glyphicon glyphicon-floppy-disk"></span> Actualizar Cliente
					</button>
					<button id="buttonClear" class="btn btn-default">
						<span class="glyphicon glyphicon-repeat"></span> Limpiar campos
					</button>
			</div>
		</div>
	</body>
</html>