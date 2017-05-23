/**
 * 
 */
package com.fra.clientes.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.models.Telefono;
import com.fra.clientes.services.ClienteService;
import com.fra.clientes.services.exceptions.ClienteNotFoundException;
import com.fra.clientes.services.exceptions.ServiceException;
import com.fra.clientes.spring.config.MainConfig;

/**
 * 
 * @author Renzo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MainConfig.class})
@Transactional
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
public class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;
	
	Cliente cliente;
	long idPrueba;
	
	@Before
	public void setup(){
		List<Telefono> telefonos = new ArrayList<>();
		telefonos.add(new Telefono(46025719));
		
		cliente = new Cliente("Renzo", telefonos, "Corvalan 2626", "Casa");
		idPrueba = 1;
	}
	
	@Test
	public void testGetClientes() throws ServiceException{
		List<Cliente> clientes = clienteService.getClientes();
		boolean empty = (clientes != null && !clientes.isEmpty()) ? false : true;
		Assert.assertFalse(empty);
		System.out.println("Clientes obtenidos correctamente");
	}
	
	@Test
	public void testGetClienteById() throws ServiceException{
		Cliente c = clienteService.getClienteById(idPrueba);
		Assert.assertEquals("Cliente Prueba", c.getNombreApellido());
		Assert.assertEquals("12345678", c.getTelefono());
		Assert.assertEquals("Una direccion", c.getDireccion());
		Assert.assertEquals("Casa", c.getEstablecimiento());
		System.out.println(String.format("Cliente obtenido por id correctamente."));
	}
	
	@Test(expected=ClienteNotFoundException.class)
	public void testNegativeGetClienteById() throws ServiceException{
		clienteService.getClienteById(0);
	}
	
	@Test
	public void testAddCliente() throws ServiceException {
		clienteService.addCliente(cliente);
		Assert.assertNotNull(cliente.getId());
		System.out.println(String.format("%s creado con ID: %d correctamente.", cliente.toString(), cliente.getId()));
	}
	
	@Test
	public void testUpdateCliente() throws ServiceException {
		Cliente c = clienteService.getClienteById(idPrueba);
		c.setNombreApellido("Otro nombre");
		c.setDireccion("Otra direccion");
		clienteService.updateCliente(c);
		
		Cliente c2 = clienteService.getClienteById(idPrueba);
		
		Assert.assertEquals("Otro nombre", c2.getNombreApellido());
		Assert.assertEquals("Otra direccion", c2.getDireccion());

		System.out.println(String.format("Cliente updateado por id correctamente"));
	}
	
	@Test(expected=ClienteNotFoundException.class)
	public void testNegativeUpdateCliente() throws ServiceException {
		cliente.setId(0);
		clienteService.updateCliente(cliente);
	}	
	
	@Test(expected=ClienteNotFoundException.class)
	public void testDeleteClienteById() throws ServiceException{
		clienteService.deleteClienteById(idPrueba);			
		clienteService.getClienteById(idPrueba);
		System.out.println(String.format("Cliente borrado correctamente."));
	}
	
	@Test(expected=ClienteNotFoundException.class)
	public void testNegativeDeleteClienteById() throws ServiceException{
		clienteService.deleteClienteById(0);
	}
}
