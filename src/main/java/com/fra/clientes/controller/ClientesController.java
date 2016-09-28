package com.fra.clientes.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("Lista", clienteService.getClientes());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/Agregar Cliente" , method = RequestMethod.GET)
	public ModelAndView redirectNewCliente(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("NewCliente");
		return modelAndView;
	}	

	@RequestMapping(value = "/Agregar Cliente", method = RequestMethod.POST)
	public String addCliente(HttpServletRequest request, HttpServletResponse response) {

		String nombreApellido = request.getParameter("nombreApellido");
//		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombreApellido,telefono,direccion,establecimiento);
		
		clienteService.addCliente(cliente);
		
		return "redirect:home";
	}
	
	@RequestMapping(value = "/Editar Cliente/{id}" , method = RequestMethod.GET)
	public ModelAndView redirectEdit(@PathVariable("id") long id , HttpServletRequest request, HttpServletResponse response) {
		
		Cliente cliente = clienteService.getClienteById(id);
		ModelAndView modelAndView = new ModelAndView("EditCliente");
		modelAndView.addObject("Cliente", cliente);
		
		return modelAndView;
	}	
	
	@RequestMapping(value = "/Editar Cliente", method = RequestMethod.POST)
	public String editCliente(HttpServletRequest request, HttpServletResponse response) {

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
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteCliente(@PathVariable("id") long id) {
		
		this.clienteService.deleteClienteById(id);
		return "redirect:/home";
	}

	public void setClienteService(ClienteService cs) {
		this.clienteService = cs;
	}
}
