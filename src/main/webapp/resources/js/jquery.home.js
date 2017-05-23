var restBaseUrl = '/clientes-abm/rest/cliente';

$(document).ready(function() {

	// Load Data Table
	var table = $('#clientes').dataTable(
			{
				language : {
				search : "Buscar cliente:",
				emptyTable : "No hay clientes",
				zeroRecords : "Ningún cliente encontrado",
				paginate : {
					previous : "Previo",
					next : "Siguiente"
				},
				info : "Mostrando de _START_ a _END_ clientes de los _TOTAL_ totales",
				lengthMenu : "Mostrar _MENU_ resultados",
				infoFiltered : "(Filtrado/s de _MAX_ totales)",
				processing : "Cargando clientes ..."
				},
				"processing" : true,
				"ajax" : {
					'type' : 'GET',
					'url' : restBaseUrl
					+ '?response=v2'
				},
				"columns" : [ {
					"className" : "dt-center",
					"data" : "nombreApellido"
				}, {
					"className" : "dt-center",
					"data" : "telefono"
				}, {
					"className" : "dt-center",
					"data" : "direccion"
				}, {
					"className" : "dt-center",
					"data" : "establecimiento"
				}, {
					"className" : "dt-center",
					"width" : "25%",
					render : function(data, type, row) {
						return botoneraAcciones(row);
					},
				} ]
			});
	
	// Sets functionality in clear button to erase field
	$('#clearButton').click(function(event) {
		$('#nombreApellido').val('');
		$('#telefono').val('');
		$('#direccion').val('');
	});
	
	// Sets functionality in banner image to reload page
	$('#banner').click(function(event) {
		window.location.replace('');
	});

	// *** MODAL FUNCTIONALITY ***
	
	// Get the modal
	var modal = document.getElementById('formModal');
	
	// Get the button that opens the modal
	var addFormBtn = document.getElementById("addForm");

	// Get the <span> element that closes the modal
	var span = document.getElementById("closeSpan");

	// When the user clicks the Agregar Cliente button, open the modal
	addFormBtn.onclick = function() {
		modal.style.display = "block";
		$('#id').val('');
		$('#nombreApellido').val('');
		$('#nombreApellido').focus();
		$('#telefono').val('');
		$('#direccion').val('');
		$('#establecimiento').val('Casa');
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

	// When the user clicks on createButton, validate client and add it if success
	$('#createButton').click(function(event) {
		$('#error').empty();
		
		var nomApe = $('#nombreApellido').val(), 
		tel = $('#telefono').val(), 
		dire = $('#direccion').val(), 
		est = $('#establecimiento').val();
		
		valid = validCliente(nomApe, tel, dire, est);
		
		if (valid[0]) {
			addOrUpdateCliente(restBaseUrl, 'POST', nomApe, tel, dire, est);
		} else {
			var errorLabel = document.getElementById("error");
			errorLabel.innerHTML = '&nbsp;&nbsp;&nbsp;'+ valid[1];
		}
	});
	
	// When the user clicks on updateButton, validate client and update it if success
	$('#updateButton').click(function(event) {
		$('#error').empty();
		
		var url = restBaseUrl + '/', 
		id = $('#id').val(), 
		nomApe = $('#nombreApellido').val(), 
		tel = $('#telefono').val(), 
		dire = $('#direccion').val(), 
		est = $('#establecimiento').val();

		url += id;
		valid = validCliente(nomApe, tel, dire, est);

		if (valid[0]) {
			addOrUpdateCliente(url, 'PATCH', nomApe, tel, dire, est);
		} else {
			var errorLabel = document.getElementById("error");
			errorLabel.innerHTML = '&nbsp;&nbsp;&nbsp;'+ valid[1];
		}
	});	
});

// When the user clicks on Editar button, open the modal with its values
function displayModalUpdate(id, nom, tel, dire, est) {
	var divModal = $('#formModal');
	divModal.css("display", "block");

	$('#id').val(id);
	$('#nombreApellido').val(nom == 'null' ? '' : nom);
	$('#telefono').val(tel == 'null' ? '' : tel);
	$('#direccion').val(dire == 'null' ? '' : dire);
	$('#establecimiento').val(est == 'null' ? '' : est);
	$('#updateButton').removeClass("hidden");
	$('#createButton').addClass("hidden");
}

// Validate a client
function validCliente(nomApe, tel, dire, est) {
	// TODO: Validar teléfono. Debería separar los teléfonos en una entidad separada. De 1 a muchos
	var msg;

	if (nomApe.length == 0 || dire.length == 0) {
		msg = '*Error! Campos sin completar.';
	} else if ((/^[a-zA-Z0-9ñÑ ]*$/.test(nomApe) == false)
			|| (/^[a-zA-Z0-9ñÑ.°" ]*$/.test(dire) == false)
			|| (/^[a-zA-Z0-9ñÑ ]*$/.test(est) == false)) {
		msg = '*Error! Caracteres especiales no permitidos.';
	} else if (/^[0-9- ]*$/.test(tel) == false) {
		msg = '*Error! Ingrese un teléfono válido.';
	} else {
		return [ true ];
	}
	return [ false, msg ];
}

// Confirm client deletion
function confirmDelete(id, nombreApellido) {
	$.confirm({
		title : 'Eliminar Cliente',
		content : 'Esta seguro que desea borrar al cliente: ' + nombreApellido + ' ?',
		buttons : {
			confirmar : {
				text : 'Confirmar',
				keys : [ 'enter' ],
				action : function() {
					var url = restBaseUrl + '/' + id;
					deleteCliente(url);
					return true;
				}
			},
			cancelar : {
				text : 'Cancelar',
				keys : [ 'esc' ]
			}
		}
	});
}

// Editar & Eliminar buttons added dynamically
function botoneraAcciones(row) {
	var html = "";

	html += '<button class="btn btn-primary" style="width: 3cm" onclick=\"displayModalUpdate('
			+ row.id
			+ ', \''
			+ row.nombreApellido
			+ '\', \''
			+ row.telefono
			+ '\', \''
			+ row.direccion
			+ '\', \''
			+ row.establecimiento
			+ '\')\">';

	html += '<span class="glyphicon glyphicon-edit">';

	html += '</span> Editar</button> '

	html += ' <button class="btn btn-danger" style="width: 3cm" onclick=\"confirmDelete('
			+ row.id + ',\'' + row.nombreApellido + '\')\">';

	html += '<span class="glyphicon glyphicon-trash">';

	html += '</span> Eliminar</button>'

	return html;
}
