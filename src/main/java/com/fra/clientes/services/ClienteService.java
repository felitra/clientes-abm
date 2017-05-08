package com.fra.clientes.services;

import java.util.List;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.exceptions.ClienteNotFoundException;

public interface ClienteService {

	public void addCliente(Cliente c);

	public void updateCliente(Cliente c) throws ClienteNotFoundException;

	public void deleteClienteById(long id) throws ClienteNotFoundException;

	public Cliente getClienteById(long id) throws ClienteNotFoundException;

	public List<Cliente> getClientes();
}
