package com.fra.clientes.controller;

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
	public ModelAndView helloWorld() {

		//TODO: Usar el home ACÁ
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("home", "message", message);
	}

	@Autowired(required = true)
	@Qualifier(value = "clienteService")
	public void setClienteService(ClienteService cs) {
		this.clienteService = cs;
	}

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
}
