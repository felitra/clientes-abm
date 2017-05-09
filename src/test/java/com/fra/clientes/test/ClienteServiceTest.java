/**
 * 
 */
package com.fra.clientes.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;
import com.fra.clientes.services.exceptions.ClienteNotFoundException;
import com.fra.clientes.services.exceptions.ServiceException;
import com.fra.clientes.spring.config.MainConfig;

/**
 * TODO: RE-DO Junit Tests
 * 
 * @author Renzo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MainConfig.class})
//TODO: Quitar configuracion web despues de arreglar el controller web
@WebAppConfiguration
public class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;
	
	Cliente cliente;
	
	@Before
	public void setup(){
		cliente = new Cliente("Renzo", "46025719", "Corvalan 2626", "Casa");
	}
	
	@Test
	//TODO: Investigar @Test + @Transactional y la posibilidad de usar BD en memoria
	public void testCrear() throws ServiceException {
		clienteService.addCliente(cliente);
		Assert.assertNotNull(cliente.getId());
		System.out.println(String.format("%s creado con ID: %d.", cliente.toString(), cliente.getId()));
	}
	
	@After
	public void testDelete() throws ServiceException{
		long id = cliente.getId();
		clienteService.deleteClienteById(id);
		
		boolean clienteNotFound = false;
		try {
			clienteService.getClienteById(id);
		} catch (ClienteNotFoundException e) {
			clienteNotFound = true;
		}
		Assert.assertTrue(clienteNotFound);
		System.out.println(String.format("Cliente con ID: %d borrado correctamente.", id));
	}
}
