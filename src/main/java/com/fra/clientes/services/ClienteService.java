package com.fra.clientes.services;

import java.util.List;

import com.fra.clientes.models.Cliente;

public interface ClienteService {

	public void addCliente(Cliente c);

	public void updateCliente(Cliente c);

	public void deleteClienteById(long id);

	public Cliente getClienteById(long id);

	public List<Cliente> getClientes();
}
