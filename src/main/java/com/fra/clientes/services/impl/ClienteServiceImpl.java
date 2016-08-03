package com.fra.clientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	
	@Transactional
	public void addCliente(Cliente c) {
		clienteDao.addCliente(c);
	}

	@Transactional
	public void updateCliente(Cliente c) {
		clienteDao.updateCliente(c);
	}

	@Transactional
	public void deleteClienteById(long id) {
		clienteDao.deleteClienteById(id);
	}

	@Transactional
	public Cliente getClienteById(long id) {
		return clienteDao.getClienteById(id);
	}

	@Transactional
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

}
