/**
 * 
 */
package com.fra.clientes.test;

import java.util.List;

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
	
//		Cliente cliente = new Cliente();
//		
//		cliente.setNombre("Aasd");
//		cliente.setApellido("Felitti");
//		cliente.setTelefono("130");
//		cliente.setDireccion("Direcicon");
//		cliente.setEstablecimiento("asdas");		
//		
//		clienteService.addCliente(cliente);
				
		List<Cliente> clientes  = clienteService.getClientes();
		
		System.out.println(clientes);
		
	}
	
}
