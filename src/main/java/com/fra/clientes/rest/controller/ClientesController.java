package com.fra.clientes.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.rest.responses.DatatableResponse;
import com.fra.clientes.services.ClienteService;
import com.fra.clientes.services.exceptions.BadRequestException;
import com.fra.clientes.services.exceptions.ServiceException;

/**
 * Rest controller para manejar toda la API de la aplicación
 * 
 * /cliente GET Listing, muestra todos los clientes. /cliente?response=v2 muestra la response con el formato que espera datatable 
 * /cliente POST Save cliente
 * /cliente/{id} GET Get cliente {id}
 * /cliente/{id} PATCH Update cliente {id}
 * /cliente/{id} DELETE Delete cliente {id} 
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
	public @ResponseBody ResponseEntity<?> getClientes(@RequestParam(required=false) String response) throws ServiceException {	
		if (response == null) {
			return new ResponseEntity<List<Cliente>>(clienteService.getClientes(), HttpStatus.OK);
		}else {
			switch (response.toLowerCase()) {
			case "v1":
				return new ResponseEntity<List<Cliente>>(clienteService.getClientes(), HttpStatus.OK);
			case "v2":
				return new ResponseEntity<DatatableResponse>(new DatatableResponse(clienteService.getClientes()), HttpStatus.OK);
			default:
				throw new BadRequestException("Bad request");
			}	
		}
	}
			
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addCliente(@RequestBody Cliente cliente) throws ServiceException {
		clienteService.addCliente(cliente);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Cliente getClienteById(@PathVariable("id") long id) throws ServiceException {
		return clienteService.getClienteById(id);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) throws ServiceException {
		cliente.setId(id);
		clienteService.updateCliente(cliente);
	}

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable("id") long id) throws ServiceException {
		this.clienteService.deleteClienteById(id);
	}
}