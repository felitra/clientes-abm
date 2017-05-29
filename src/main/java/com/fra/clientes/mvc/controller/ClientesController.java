package com.fra.clientes.mvc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fra.clientes.services.exceptions.ServiceException;

/**
 * Web controller para manejar la aplicación
 * 
 * /home GET Listing, muestra todos los clientes 
 * 
 * @author renzo.ariel.felitti
 *
 */

@Controller("webController")
public class ClientesController {
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView home() throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("Home");		
		return modelAndView;
	}
}