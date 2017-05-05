package com.fra.clientes.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

/**
 * Rest controller para manejar toda la API de la aplicación
 * 
 * /cliente GET Listing, muestra todos los clientes 
 * /cliente POST Save cliente
 * /cliente/{id} DELETE Delete cliente {id} 
 * /cliente/{id} PATCH Update cliente {id}
 * 
 * @author renzo.ariel.felitti
 *
 */

@Controller("restController")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Cliente> cliente() {
		return clienteService.getClientes();
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addCliente(@RequestBody Cliente cliente) {
		clienteService.addCliente(cliente);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editCliente(@PathVariable("id") long id,
			@RequestBody Cliente cliente) {
		cliente.setId(id);
		clienteService.updateCliente(cliente);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable("id") long id) {
		this.clienteService.deleteClienteById(id);
	}

}