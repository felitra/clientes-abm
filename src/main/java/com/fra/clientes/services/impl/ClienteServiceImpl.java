package com.fra.clientes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;
	
	public void addCliente(Cliente c) {
		clienteDao.addCliente(c);
	}

	public void updateCliente(Cliente c) {
		clienteDao.updateCliente(c);
	}

	public void deleteClienteById(long id) {
		clienteDao.deleteClienteById(id);
	}

	public Cliente getClienteById(long id) {
		return clienteDao.getClienteById(id);
	}

	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}

}