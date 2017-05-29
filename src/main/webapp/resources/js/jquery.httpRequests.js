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
			var msg;
			if (verb == 'POST') {
				msg = "Cliente creado exitosamente!";
			} else {
				msg = "Cliente actualizado exitosamente!";
			}
			$.alert({
				title: 'OK!',
	        	type: 'green',
	        	content: msg,
	        	buttons: {
  			        ok:{
  			        	text: 'ok',
  			        	keys: ['enter']
  			        }
  			    }
			});
			$('#clientes').DataTable().ajax.reload();
		},
		'error' : function(XMLHttpRequest, textStatus, errorThrown) {
			var msg;
			
			if (verb == 'POST') {
				msg = "Error creando cliente, intente mas tarde";
			} else {
				msg = "Error actualizando cliente, intente mas tarde";
			}

			$.alert({
				title: 'Error',
	        	type: 'red',
	        	content: msg,
	        	buttons: {
  			        ok:{
  			        	text: 'ok',
  			        	keys: ['enter']
  			        }
  			    }
			});
		}
	});
}

function deleteCliente(url) {
	return jQuery.ajax({
		'type' : 'DELETE',
		'url' : url,
		'success' : function(XMLHttpRequest, textStatus, errorThrown) {
			$.alert({
                title: 'Eliminar',
                type: 'green',
                content: 'Cliente borrado exitosamente!.',
                buttons: {
  			        ok:{
  			        	text: 'ok',
  			        	keys: ['enter']
  			        }
  			    }                
            });
			$('#clientes').DataTable().ajax.reload();
		},
		'error' : function(XMLHttpRequest, textStatus, errorThrown) {
			 $.alert({
                 title: 'Error',
                 type: 'red',
                 content: 'Error borrando cliente, intente mas tarde.',
                 buttons: {
   			        ok:{
   			        	text: 'ok',
   			        	keys: ['enter']
   			        }
   			    }
             });
		}
	});
}
