package com.fra.clientes.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

public class ClienteServiceImpl implements ClienteService {

	private ClienteDao clienteDao;

	public void setPersonDAO(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Transactional
	public void addCliente(Cliente c) {
		clienteDao.addCliente(c);
	}

	@Transactional
	public void updateCliente(Cliente c) {
		clienteDao.updateCliente(c);
	}

	@Transactional
	public void removeCliente(int id) {
		clienteDao.removeCliente(id);
	}

	@Transactional
	public Cliente getClienteById(int id) {
		return clienteDao.getClienteById(id);
	}

	@Transactional
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}

}
