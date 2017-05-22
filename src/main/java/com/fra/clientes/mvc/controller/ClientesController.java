package com.fra.clientes.mvc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;
import com.fra.clientes.services.exceptions.ServiceException;

/**
 * Web controller para manejar la aplicación
 * 
 * /home GET Listing, muestra todos los clientes 
 * /cliente/form/add GET Listing, muestra el form para creacion de clientes
 * /cliente/{id}/form/update GET Listing, muestra el form para update del cliente {id}
 * 
 * @author renzo.ariel.felitti
 *
 */

@Controller("webController")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView home() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("Home");		
		return modelAndView;
	}

	@RequestMapping(value = "/cliente/form/add" , method = RequestMethod.GET)
	public ModelAndView formAddCliente() {
		ModelAndView modelAndView = new ModelAndView("DetalleCliente");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cliente/{id}/form/update" , method = RequestMethod.GET)
	public ModelAndView formUpdateCliente(@PathVariable("id") long id) throws ServiceException {
		Cliente cliente = clienteService.getClienteById(id);
		ModelAndView modelAndView = new ModelAndView("DetalleCliente");
		modelAndView.addObject("Cliente", cliente);
		return modelAndView;
	}	

}