/**
 * 
 */
package com.fra.clientes.test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.spring.config.MainConfig;
import com.fra.clientes.spring.config.RestConfig;


/**
 * @author renzo.ariel.felitti
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {MainConfig.class, RestConfig.class})
@Transactional
@WebAppConfiguration
@TransactionConfiguration(defaultRollback=true, transactionManager="transactionManager")
public class ClientesRestController {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private Cliente cliente;
	private long idPrueba;
	
	@Before
	public void setup(){
		cliente = new Cliente("Renzo", "46025719", "Corvalan 2626", "Casa");
		idPrueba = 1;
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	private static byte[] convertObjectToJsonBytes(Object object)throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	@Test
	public void testGetClientes() throws Exception {
		String queryParam= "?response=";
		
		mockMvc.perform(get("/cliente"))
				.andExpect(status().isOk());
		
		mockMvc.perform(get(String.format("/cliente%sv1", queryParam)))
				.andExpect(status().isOk());

		mockMvc.perform(get(String.format("/cliente%sv2", queryParam)))
				.andExpect(status().isOk());
		
		mockMvc.perform(get(String.format("/cliente%sv3", queryParam)))
				.andExpect(status().isBadRequest());
		
		System.out.println("Servicio GET /cliente funcionando correctamente.");
	}
	
	@Test
	public void testGetClienteById() throws Exception {
		mockMvc.perform(get("/cliente/{id}", idPrueba))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1) ))
				.andExpect(jsonPath("$.nombreApellido", is("Cliente Prueba")))
				.andExpect(jsonPath("$.telefono", is("12345678")))
				.andExpect(jsonPath("$.direccion", is("Una direccion")))
				.andExpect(jsonPath("$.establecimiento", is("Casa")));
		
		mockMvc.perform(get("/cliente/{id}", 0))
				.andExpect(status().isNotFound());
		
		System.out.println("Servicio GET /cliente/{id} funcionando correctamente.");
	}
	
	@Test
	public void testAddCliente() throws Exception{
		mockMvc.perform(post("/cliente")
				.content(convertObjectToJsonBytes(cliente))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
		System.out.println("Servicio POST /cliente funcionando correctamente.");
	}
	
	@Test
	public void testEditCliente() throws Exception{
		mockMvc.perform(request(HttpMethod.PATCH, String.format("/cliente/%s", idPrueba))
				.content(convertObjectToJsonBytes(cliente))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		
		mockMvc.perform(request(HttpMethod.PATCH, String.format("/cliente/%s", 0))
				.content(convertObjectToJsonBytes(cliente))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
		
		System.out.println("Servicio PATCH /cliente/{id} funcionando correctamente.");
	}
	
	@Test
	public void testDeleteCliente() throws Exception{
		mockMvc.perform(delete("/cliente/{id}", idPrueba))
				.andExpect(status().isNoContent());
		
		mockMvc.perform(delete("/cliente/{id}", 0))
				.andExpect(status().isNotFound());
		
		System.out.println("Servicio DELETE /cliente/{id} funcionando correctamente.");
	}	
}