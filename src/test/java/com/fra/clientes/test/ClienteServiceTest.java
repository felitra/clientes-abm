/**
 * 
 */
package com.fra.clientes.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
public class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;
	Cliente cliente;
	long idPrueba;
	
	@Before
	public void setup(){
		cliente = new Cliente("Renzo", "46025719", "Corvalan 2626", "Casa");
		idPrueba = 1;
	}
	
	@Test
	public void testGetClienteById() throws ServiceException{
		Cliente c = clienteService.getClienteById(idPrueba);
		Assert.assertNotNull(c);
		System.out.println(String.format("Cliente obtenido por id correctamente."));
	}
	
	@Test
	public void testCrear() throws ServiceException {
		clienteService.addCliente(cliente);
		Assert.assertNotNull(cliente.getId());
		System.out.println(String.format("%s creado con ID: %d.", cliente.toString(), cliente.getId()));
	}
	
	@Test
	public void testDelete() throws ServiceException{
		clienteService.deleteClienteById(idPrueba);
		
		boolean clienteNotFound = false;
		try {
			clienteService.getClienteById(idPrueba);
		} catch (ClienteNotFoundException e) {
			clienteNotFound = true;
		}
		Assert.assertTrue(clienteNotFound);
		System.out.println(String.format("Cliente borrado correctamente."));
	}
}
