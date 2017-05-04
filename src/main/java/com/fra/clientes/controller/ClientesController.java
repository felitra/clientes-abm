package com.fra.clientes.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

@Controller
public class ClientesController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * SPRING MVC
	 * 
	 */
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView home() {
		
		//TODO: MANEJO LA RESPUESTA DE JSON
		List<Cliente> clientes = cliente();
		
		ModelAndView modelAndView = new ModelAndView("Home");
		modelAndView.addObject("Lista", clientes);
		
		return modelAndView;
	}

	@RequestMapping(value = "/cliente/form/add" , method = RequestMethod.GET)
	public ModelAndView formAddCliente() {
		ModelAndView modelAndView = new ModelAndView("NewCliente");
		return modelAndView;
	}
	
	@RequestMapping(value = "/cliente/{id}/form/update" , method = RequestMethod.GET)
	public ModelAndView formUpdateCliente(@PathVariable("id") long id) {
		
		Cliente cliente = clienteService.getClienteById(id);
		ModelAndView modelAndView = new ModelAndView("EditCliente");
		modelAndView.addObject("Cliente", cliente);
		
		return modelAndView;
	}	


	/**
	 * REST API
	 * 
	 */
	
	@RequestMapping(value = "/cliente" , method = RequestMethod.GET)
	public List<Cliente> cliente() {
		//TODO: DEVOLVER UN JSON
		return clienteService.getClientes();
	}
	

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String saveOrUpdate(HttpServletRequest request) {

		//TODO: RECIBIR UN JSON
		
		String nombreApellido = request.getParameter("nombreApellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombreApellido,telefono,direccion,establecimiento);
		
		clienteService.addCliente(cliente);
		
		return "redirect:home";
	}
		
	@RequestMapping(value = "/Editar Cliente", method = RequestMethod.POST)
	public String editCliente(HttpServletRequest request) {

		//TODO: USAR EL SAVE OR UPDATE, BORRAR ESTE METODO
		
		long id = Long.valueOf(request.getParameter("id"));
		String nombreApellido = request.getParameter("nombreApellido");
//		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombreApellido,telefono,direccion,establecimiento);
		cliente.setId(id);
		
		clienteService.updateCliente(cliente);
				
		return "redirect:home";
	}	
	

	@RequestMapping(value = "/cliente/{id}/delete", method = RequestMethod.POST)
	public String deleteCliente(@PathVariable("id") long id) {
		
		//TODO: SOLO RETORNAR STATUS CODE
		this.clienteService.deleteClienteById(id);
		return "redirect:/home";
	}

}
