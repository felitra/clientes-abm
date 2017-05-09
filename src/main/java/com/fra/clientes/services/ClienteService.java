package com.fra.clientes.services;

import java.util.List;

import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.exceptions.ServiceException;

public interface ClienteService {

	public void addCliente(Cliente c) throws ServiceException;
	public void updateCliente(Cliente c) throws ServiceException;
	public void deleteClienteById(long id) throws ServiceException;
	public Cliente getClienteById(long id) throws ServiceException;
	public List<Cliente> getClientes() throws ServiceException;
}
