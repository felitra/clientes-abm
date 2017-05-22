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
			    	$('#error').empty();	
			    	var url = '${restBaseUrl}',
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    	
			    	valid = validCliente(nomApe, tel, dire, est);
			    	
			    	if (valid[0]) {
			    		addOrUpdateCliente(url, 'POST', nomApe, tel, dire, est);
					} else{
						var errorLabel = document.getElementById("error");
			    		errorLabel.innerHTML= '&nbsp;&nbsp;&nbsp;' + valid[1];
					}
			    });
			    
			    $('#buttonUpdate').click(function(event){
			    	$('#error').empty();
			    	var url = '${restBaseUrl}/',
			    		id = $('#id').val(),
			    		nomApe = $('#nombreApellido').val(),
			    		tel = $('#telefono').val(),
			    		dire = $('#direccion').val(),
			    		est = $('#establecimiento').val();
			    	
			    	url += id;
			    	valid = validCliente(nomApe, tel, dire, est);
			    	
			    	if (valid[0]) {
			    		addOrUpdateCliente(url, 'PATCH', nomApe, tel, dire, est);
			    	} else{
						var errorLabel = document.getElementById("error");
			    		errorLabel.innerHTML= '&nbsp;&nbsp;&nbsp;' + valid[1];
					}
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
			
			function validCliente(nomApe, tel, dire, est){
				//TODO: Validar teléfono. Debería separar los teléfonos en una entidad separada. De 1 a muchos
				var msg;
				
				if (nomApe.length == 0 || dire.length == 0) {
					msg = '*Error! Campos sin completar.';
				} else if ((/^[a-zA-Z0-9ñÑ ]*$/.test(nomApe) == false) 
						|| (/^[a-zA-Z0-9ñÑ.°" ]*$/.test(dire) == false) 
						|| (/^[a-zA-Z0-9ñÑ ]*$/.test(est) == false)) {
					msg = '*Error! Caracteres especiales no permitidos.';
				} else if (/^[0-9- ]*$/.test(tel) == false){
					msg = '*Error! Ingrese un teléfono válido.';
				} else{
					return [ true ];
				}
				return [ false, msg ];
			}
		</script>
  		
	</head>
	<body style="background-color:menu; ">
		
		<div class="upcon">
	    	<img id="banner" src="${resources}/images/home-header.jpg" class="banner"/>
		</div>
		<br>
		<div class="container-fluid">
			<div class="container content-size">
					<div class="form-group">
						<input type="text" class="form-control hidden" id="id">
						<br>
		  				<label for="nomape">Nombre y Apellido:</label>
		  				<input type="text" class="form-control" id="nombreApellido" placeholder="Letras de A-Z, números">
		  				<br>
		  				<label for="tel">Teléfono:</label>
		  				<input type="text" class="form-control" id="telefono" placeholder="Números y guión medio">
		  				<br>
		  				<label for="dire">Dirección:</label>
		  				<input type="text" class="form-control" id="direccion" placeholder="Letras de A-Z, números, comillas, puntos y caracter: °">
		  				<br>
		  				<label for="est">Establecimiento:</label>
		  				<input type="text" class="form-control" id="establecimiento" placeholder="Letras de A-Z, números">
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
					<label id="error" style="color: red;"></label>
			</div>
		</div>
	</body>
</html>