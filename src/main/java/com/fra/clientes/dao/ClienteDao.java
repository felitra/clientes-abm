package com.fra.clientes.dao;

import java.util.List;

import com.fra.clientes.models.Cliente;

public interface ClienteDao {

	public void addCliente(Cliente c);
	public void updateCliente(Cliente c);
	public void deleteClienteById(long id);
	public Cliente getClienteById(long id);
	public List<Cliente> getClientes();
}
