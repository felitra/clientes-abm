function getClientes(url) {
	return jQuery.ajax({
		'type' : 'GET',
		'url' : url
	});
}

function addOrUpdateCliente(url, verb, nomApe, tel, dire, est) {
	return jQuery.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		'type' : verb,
		'url' : url,
		'data' : JSON.stringify({
			nombreApellido : nomApe,
			telefono : tel,
			direccion : dire,
			establecimiento : est
		}),
		'success' : function(XMLHttpRequest, textStatus, errorThrown) {
			if (verb == 'POST') {
				alert("Cliente creado exitosamente!")
			} else {
				alert("Cliente actualizado exitosamente!")
			}
		},
		'error' : function(XMLHttpRequest, textStatus, errorThrown) {
			if (verb == 'POST') {
				alert("Error creando cliente, intente mas tarde")
			} else {
				alert("Error actualizando cliente, intente mas tarde")
			}
		}
	});
}

function deleteCliente(url) {
	return jQuery.ajax({
		'type' : 'DELETE',
		'url' : url,
		'success' : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("Cliente borrado exitosamente!");
			window.location.replace('');
		},
		'error' : function(XMLHttpRequest, textStatus, errorThrown) {
			alert("Error borrando cliente, intente mas tarde");
		}
	});
}
