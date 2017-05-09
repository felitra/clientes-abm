package com.fra.clientes.dao;

import java.sql.SQLException;
import java.util.List;

import com.fra.clientes.models.Cliente;

public interface ClienteDao {

	public void addCliente(Cliente c);
	public void updateCliente(Cliente c) throws SQLException;
	public void deleteClienteById(long id) throws SQLException;
	public Cliente getClienteById(long id) throws SQLException;
	public List<Cliente> getClientes();
}
