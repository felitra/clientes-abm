package com.fra.clientes.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

@RestController
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/cliente" , method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> cliente() {
		//TODO: DEVOLVER UN JSON, BUSCAR JACKSON
		return clienteService.getClientes();
	}
	

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addCliente(HttpServletRequest request) {

		//TODO: RECIBIR UN JSON
		
		String nombreApellido = request.getParameter("nombreApellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombreApellido,telefono,direccion,establecimiento);
		
		clienteService.addCliente(cliente);
	}
		
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PATCH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editCliente(HttpServletRequest request) {

		//TODO: RECIBIR UN JSON
		
		long id = Long.valueOf(request.getParameter("id"));
		String nombreApellido = request.getParameter("nombreApellido");
//		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombreApellido,telefono,direccion,establecimiento);
		cliente.setId(id);
		
		clienteService.updateCliente(cliente);
	}	
	

	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable("id") long id) {		
		this.clienteService.deleteClienteById(id);
	}

}
