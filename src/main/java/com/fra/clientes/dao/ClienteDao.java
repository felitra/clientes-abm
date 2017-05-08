package com.fra.clientes.dao;

import java.util.List;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.exceptions.ClienteNotFoundException;

public interface ClienteDao {

	public void addCliente(Cliente c);
	public void updateCliente(Cliente c) throws ClienteNotFoundException;
	public void deleteClienteById(long id) throws ClienteNotFoundException;
	public Cliente getClienteById(long id) throws ClienteNotFoundException;
	public List<Cliente> getClientes();
}
