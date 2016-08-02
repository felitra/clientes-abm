package com.fra.clientes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		//TODO: Usar el home ACÁ
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("Lista", clienteService.getClientes());
		
		return modelAndView;
	}
	
//	@RequestMapping(value = "/cliente/add" , method = RequestMethod.GET)
//	public ModelAndView addClient(HttpServletRequest request, HttpServletResponse response) {
//		
//		ModelAndView modelAndView = new ModelAndView("NewClient");
//		
//		return modelAndView;
//	}


	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listClientes", this.clienteService.getClientes());
		return "cliente";
	}

	// For add and update person both
	@RequestMapping(value = "/cliente/add", method = RequestMethod.POST)
	public String addCliente(@ModelAttribute("cliente") Cliente c) {

		if (c.getId() == 0) {
			// new person, add it
			this.clienteService.addCliente(c);
		} else {
			// existing person, call update
			this.clienteService.updateCliente(c);
		}

		return "redirect:/clientes";

	}

	@RequestMapping("/remove/{id}")
	public String removeCliente(@PathVariable("id") int id) {

		this.clienteService.removeCliente(id);
		return "redirect:/clientes";
	}

	@RequestMapping("/edit/{id}")
	public String editCliente(@PathVariable("id") int id, Model model) {
		model.addAttribute("cliente", this.clienteService.getClienteById(id));
		model.addAttribute("listClientes", this.clienteService.getClientes());
		return "cliente";
	}
	
	@Autowired(required = true)
	@Qualifier(value = "clienteService")
	public void setClienteService(ClienteService cs) {
		this.clienteService = cs;
	}
}
