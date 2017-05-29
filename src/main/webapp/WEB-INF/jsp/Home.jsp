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
		<link rel="stylesheet" href="${resources}/css/utils.css" type="text/css">
		<link rel="stylesheet" href="${resources}/css/jquery-confirm.min.css" type="text/css">

		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/bootstrap.min.js" type="text/javascript" charset="utf8"></script>
  		<script src="${resources}/js/jquery.dataTables.js" type="text/javascript" charset="utf8"></script>		
		<script src="${resources}/js/jquery.httpRequests.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.accentNeutralise.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.accentNeutraliseOverride.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery-confirm.min.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.httpRequests.js" type="text/javascript" charset="utf8"></script>		
		<script src="${resources}/js/jquery.home.js" type="text/javascript" charset="utf8"></script>
	</head>
	<body style="background-color:menu; ">
		
<%-- 	To resolve properties use:	<spring:eval var="variable" expression="@environment.getProperty('property')" /> --%>
			
		<!-- Image Banner -->
		<div class="upcon">
	    	<img id="banner" src="${resources}/images/home-header.jpg" class="banner"/>
		</div>					
		
		<!-- The Modal -->
		<div id="modalForm" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">
				
				<!-- Modal content -->
				<div class="modal-content">
					
					<!-- Modal header -->
					<div class="modal-header">
	       			  <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h4 class="modal-title"></h4>
			        </div>
					
					<!-- Modal body -->
					<div class="modal-body">
						<div class="form-group content-size">
							<input type="text" class="form-control hidden" id="id">
							<label for="nomape">Nombre y Apellido:</label>
							<input type="text" class="form-control" id="nombreApellido" placeholder="Letras de A-Z, números">
							<br>
							<label for="tel">Teléfono:</label>
							<input type="text" class="form-control" id="telefono" placeholder="Números y guión medio">
							<br>
							<label for="dire">Dirección:</label>
							<input type="text" class="form-control" id="direccion" placeholder="Letras de A-Z, números, puntos y caracter: °">
							<br>
							<label for="est">Establecimiento:</label>
							<input type="text" class="form-control" id="establecimiento" placeholder="Letras de A-Z, números">
							<br>				
							<button id="addButton" class="btn btn-default hidden">
								<span class="glyphicon glyphicon-floppy-disk"></span> Agregar Cliente
							</button>
							<button id="updateButton" class="btn btn-default hidden">
								<span class="glyphicon glyphicon-floppy-disk"></span> Actualizar Cliente
							</button>
							<button id="clearButton" class="btn btn-default">
								<span class="glyphicon glyphicon-repeat"></span> Limpiar campos
							</button>
							<label id="error" style="color: red; font-size: 16px; font-weight: bold;"></label>
						</div>
					</div>
					
					<!-- Modal footer -->
					<div class="modal-footer"></div>
					
				</div>
			</div>
		</div>
		
		<!-- Home page -->
		<div class="container-fluid">
			<div class="container">
				<br>
				<br>
				<button id="addForm" class="btn btn-default content-size" data-toggle="modal" data-target="#modalForm">
				<span class="glyphicon glyphicon-plus"></span> Agregar Cliente
				</button>
				<br>
				<br>
				<table  class="display compact cell-border content-size" id="clientes">
					<thead>
						<tr>
	        			<th>Nombre y Apellido</th>
	       				<th>Teléfono</th>
	      				<th>Dirección</th>
	      				<th>Establecimiento</th>
	      				<th>Acción</th>	      				
	      				</tr>
	    			</thead>
	  			</table>
			</div>
		</div>
	</body>	
</html>

