package com.fra.clientes.services;

import java.util.List;

import com.fra.clientes.models.Cliente;

public interface ClienteService {

	public void addCliente(Cliente c);

	public void updateCliente(Cliente c);

	public void removeCliente(int id);

	public Cliente getClienteById(int id);

	public List<Cliente> getClientes();
}
