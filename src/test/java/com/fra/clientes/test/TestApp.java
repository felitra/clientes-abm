/**
 * 
 */
package com.fra.clientes.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

/**
 * @author Renzo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-clientes-abm.xml"})
public class TestApp {

	@Autowired
	ClienteService clienteService;
	
	@Test
	public void testApp(){
	
		Cliente cliente = new Cliente();
		
		cliente.setNombre("Renzo");
		cliente.setApellido("Felitti");
		cliente.setTelefono("46025719");
		cliente.setDireccion("Corvalan 2626");
		cliente.setEstablecimiento("Casa");		
		cliente.setId(2);
		
		clienteService.updateCliente(cliente);
				
		
	}
	
}
