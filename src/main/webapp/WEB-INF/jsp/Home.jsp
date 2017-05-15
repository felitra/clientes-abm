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
		<spring:url value="/" var="baseUrl" />
		<spring:url value="/rest/cliente" var="restBaseUrl" />
													
		<link rel="stylesheet" href="${resources}/css/bootstrap.min.css" type="text/css">				
		<link rel="stylesheet" href="${resources}/css/jquery.dataTables.css" type="text/css">
		<link rel="stylesheet" href="${resources}/css/utils.css" type="text/css">

		<script src="${resources}/js/jquery.min.js" type="text/javascript" charset="utf8"></script>
  		<script src="${resources}/js/jquery.dataTables.js" type="text/javascript" charset="utf8"></script>		
	
  		<script type="text/javascript" class="init">	  		
  			$(document).ready(function() {  			
  		        $('#clientes').dataTable( {
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
  		            	infoFiltered: "(Filtrado/s de _MAX_ totales)"
  		            },
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
  		        
  		      	$('#banner').click(function(event) {
	  	  			window.location.replace('${baseUrl}');
  	  			}); 		        
  		    });
  			  			
	  		function confirmDelete(id, nombreApellido){
	  			var x = confirm("Esta seguro que desea borrar al cliente: " + nombreApellido + " ?");
				if (x){
					
					var url = '${restBaseUrl}/';
					url += id;
					
					return jQuery.ajax({
			    	    'type': 'DELETE',
			    	    'url': url,
			    	    'success':  function(XMLHttpRequest, textStatus, errorThrown) {
				    	    	alert( "Cliente borrado exitosamente!" );
				  	  			window.location.replace('${baseUrl}');
			    	    	},
			    	    'error': function(XMLHttpRequest, textStatus, errorThrown) {
				    	    	alert( "Error borrando cliente, intente mas tarde" );
			    	    	}
			    	    });
					
			    	return true;
				} else {
			    	return false;
	  			}
			}
	  		
  			function botoneraAcciones(row){
  			   	var html = "";

  		      	html += '<button class="btn btn-primary content-size" style="width: 3cm" onclick=\"location.href=\'${baseUrl}app/cliente/' + row.id + '/form/update\'\">';
  		        
  		        html +='<span class="glyphicon glyphicon-edit">';

  		        html +='</span> Editar</button> '
  		        
  		      	html += ' <button class="btn btn-danger content-size" style="width: 3cm" onclick=\"confirmDelete('+row.id+',\''+row.nombreApellido+'\')\">';
  		        
  		        html +='<span class="glyphicon glyphicon-trash">';
  		        
  		        html +='</span> Eliminar</button>'
  		        
  		        return html;
  			}

  		</script>
	</head>
	<body style="background-color:menu; ">
		
<%-- 	To resolve properties use:	<spring:eval var="variable" expression="@environment.getProperty('property')" /> --%>
							
		<div class="upcon">
	    	<img id="banner" src="${resources}/images/home-header.jpg" style="width:100%; cursor:pointer"/>
		</div>
		<div class="container-fluid">
			<div class="container">
				<br>
				<br>
				<button name="button" class="btn btn-default content-size" onclick="location.href='${baseUrl}app/cliente/form/add'">
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

