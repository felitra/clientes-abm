package com.fra.clientes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView addClient(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("NewClient");
		return modelAndView;
	}	

	@RequestMapping(value = "/Agregar Cliente", method = RequestMethod.POST)
	public String addCliente(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String establecimiento = request.getParameter("establecimiento");
		
		Cliente cliente = new Cliente(nombre,apellido,telefono,direccion,establecimiento);
		
		clienteService.addCliente(cliente);
		
		return "redirect:home";
	}
//
//	@RequestMapping("/remove/{id}")
//	public String removeCliente(@PathVariable("id") int id) {
//
//		this.clienteService.removeCliente(id);
//		return "redirect:/clientes";
//	}
//
//	@RequestMapping("/edit/{id}")
//	public String editCliente(@PathVariable("id") int id, Model model) {
//		model.addAttribute("cliente", this.clienteService.getClienteById(id));
//		model.addAttribute("listClientes", this.clienteService.getClientes());
//		return "cliente";
//	}
	
//	@Autowired(required = true)
//	@Qualifier(value = "clienteService")
	public void setClienteService(ClienteService cs) {
		this.clienteService = cs;
	}
}
