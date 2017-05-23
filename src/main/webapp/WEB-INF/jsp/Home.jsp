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
													
		<link rel="stylesheet" href="${resources}/css/bootstrap.min.css" type="text/css">				
		<link rel="stylesheet" href="${resources}/css/jquery.dataTables.css" type="text/css">
		<link rel="stylesheet" href="${resources}/css/utils.css" type="text/css">
		<link rel="stylesheet" href="${resources}/css/jquery-confirm.min.css" type="text/css">

		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
  		<script src="${resources}/js/jquery.dataTables.js" type="text/javascript" charset="utf8"></script>		
		<script src="${resources}/js/jquery.httpRequests.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.accentNeutralise.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.accentNeutraliseOverride.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery-confirm.min.js" type="text/javascript" charset="utf8"></script>
		<script src="${resources}/js/jquery.httpRequests.js" type="text/javascript" charset="utf8"></script>		
							
  		<script type="text/javascript" class="init">	  		
  			$(document).ready(function() {  			
  		        var table = $('#clientes').dataTable( {
		  		            language: {
		  		                search: "Buscar cliente:",
		  		              	emptyTable: "No hay clientes",
		  		              	zeroRecords: "Ningún cliente encontrado",
		  			            paginate: {
			  		                previous:   "Previo",
			  		                next:       "Siguiente"
		  		            	},
		  		            	info: "Mostrando de _START_ a _END_ clientes de los _TOTAL_ totales",
		  		            	lengthMenu: "Mostrar _MENU_ resultados",
		  		            	infoFiltered: "(Filtrado/s de _MAX_ totales)",
		  		            	processing: "Cargando clientes ..."
		  		            },
		  		          	"processing": true,
		  		            "ajax": {	            	
		  			    	    'type': 'GET',
		  			    	    'url': '${restBaseUrl}?response=v2'
		  			    	    },
		  			    	"columns": [
		  				    	        { 
		  				    	        	"className": "dt-center",
		  				    	        	"data" : "nombreApellido"
		  				    	        },
			  			    	        { 
		  				    	        	"className": "dt-center",
		  				    	        	"data" : "telefono"
		  				    	        },
			  			    	        { 
		  				    	        	"className": "dt-center",
		  				    	        	"data" : "direccion"
		  				    	        },
			  			    	        { 
		  				    	        	"className": "dt-center",
		  				    	        	"data" : "establecimiento"
		  				    	        },
			  			    	      	{
		  				    	          	"className": "dt-center",
											"width": "25%",
			  			                  	render: function (data, type, row) { return botoneraAcciones(row); },
			  			              	}
		  			    	        ]
		  		        } );
  		      	
  		        $('#clearButton').click(function(event){
			    	$('#nombreApellido').val('');
			    	$('#telefono').val('');
			    	$('#direccion').val('');
			    });
  		      
  		      	$('#banner').click(function(event) {
	  	  			window.location.replace('');
  	  			}); 		          		      
  		      
  		   		// Get the modal
  	  			var modal = document.getElementById('myModal');

  	  			// Get the button that opens the modal
  	  			var btn = document.getElementById("addForm");

  	  			// Get the <span> element that closes the modal
  	  			var span = document.getElementById("mySpan");

  	  			// When the user clicks the button, open the modal 
  	  			btn.onclick = function() {
  	  			    modal.style.display = "block";
	  	  			$('#id').val('');
	  				$('#nombreApellido').val('');
			    	$('#telefono').val('');
			    	$('#direccion').val('');
			    	$('#establecimiento').val('');
			    	$('#createButton').removeClass("hidden");
			    	$('#updateButton').addClass("hidden");
  	  			}

  	  			// When the user clicks on <span> (x), close the modal
  	  			span.onclick = function() {
  	  			    modal.style.display = "none";
  	  			}

  	  			// When the user clicks anywhere outside of the modal, close it
  	  			window.onclick = function(event) {
  	  			    if (event.target == modal) {
  	  			        modal.style.display = "none";
  	  			    }
  	  			}
  	  			
	  	  		$('#createButton').click(function(event){
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
			    
			    $('#updateButton').click(function(event){
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
			    
  		    });
  			
  			function displayModalUpdate(id, nom, tel, dire, est){
  				var divModal = $('#myModal');  				
  				divModal.css("display", "block");
  				
  				$('#id').val(id);
  				$('#nombreApellido').val(nom == 'null' ? '': nom);
		    	$('#telefono').val(tel == 'null' ? '': tel);
		    	$('#direccion').val(dire == 'null' ? '': dire);
		    	$('#establecimiento').val(est == 'null' ? '': est);
		    	$('#updateButton').removeClass("hidden");
		    	$('#createButton').addClass("hidden");
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
  			  					  			
	  		function confirmDelete(id, nombreApellido){
	  			$.confirm({
	  			    title: 'Eliminar Cliente',
	  			    content: 'Esta seguro que desea borrar al cliente: ' + nombreApellido + ' ?',
	  			    buttons: {
	  			        confirmar:{
	  			        	text: 'Confirmar',
	  			        	keys: ['enter'],
	  			            action: function(){
	  			            	var url = '${restBaseUrl}/' + id;
		  						deleteCliente(url);
		  			            return true;
	  			            }
	  			        },
	  			        cancelar:{
	  			        	text:'Cancelar',
	  			        	keys: ['esc']
	  			        } 
	  			    }
	  			});
			}
	  		
  			function botoneraAcciones(row){
  			   	var html = "";

  			   	html += '<button class="btn btn-primary" style="width: 3cm" onclick=\"displayModalUpdate(' + row.id + ', \'' + row.nombreApellido + '\', \'' + row.telefono + '\', \'' + row.direccion + '\', \'' + row.establecimiento + '\')\">';
		      	
  		        html +='<span class="glyphicon glyphicon-edit">';

  		        html +='</span> Editar</button> '
  		        
  		      	html += ' <button class="btn btn-danger" style="width: 3cm" onclick=\"confirmDelete('+row.id+',\''+row.nombreApellido+'\')\">';
  		        
  		        html +='<span class="glyphicon glyphicon-trash">';
  		        
  		        html +='</span> Eliminar</button>'
  		        
  		        return html;
  			}
  			 
  		</script>
	</head>
	<body style="background-color:menu; ">
		
<%-- 	To resolve properties use:	<spring:eval var="variable" expression="@environment.getProperty('property')" /> --%>
							
		<div class="upcon">
	    	<img id="banner" src="${resources}/images/home-header.jpg" class="banner"/>
		</div>					
		<!-- The Modal -->
		<div id="myModal" class="modal">
			<!-- Modal content -->
			<div class="modal-content">
				<span id="mySpan" class="close">&times;</span>
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
				</div>
				<br>				
				<button id="createButton" class="btn btn-default hidden">
					<span class="glyphicon glyphicon-floppy-disk"></span> Agregar Cliente
				</button>
				<button id="updateButton" class="btn btn-default hidden">
					<span class="glyphicon glyphicon-floppy-disk"></span> Actualizar Cliente
				</button>
				<button id="clearButton" class="btn btn-default">
					<span class="glyphicon glyphicon-repeat"></span> Limpiar campos
				</button>
				<label id="error" style="color: red;"></label>
				<br>
				<br>
			</div>
		</div>
		<div class="container-fluid">
			<div class="container">
				<br>
				<br>
<!-- 				<button name="button" class="btn btn-default content-size" onclick="location.href='cliente/form/add'"> -->
				<button id="addForm" class="btn btn-default content-size">
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

