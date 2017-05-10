package com.fra.clientes.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.ClienteService;
import com.fra.clientes.services.exceptions.ExceptionHandler;
import com.fra.clientes.services.exceptions.ServiceException;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	private static final Logger LOGGER = Logger.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteDao clienteDao;
	
	public void addCliente(Cliente c) throws ServiceException{
		try {
			clienteDao.addCliente(c);
			LOGGER.info("Cliente almacenado exitosamente, Detalles= " + c.toString());			
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
	}

	public void updateCliente(Cliente c) throws ServiceException {
		try {
			clienteDao.updateCliente(c);
			LOGGER.info("Cliente actualizado exitosamente, Detalles= " + c.toString());
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
	}

	public void deleteClienteById(long id) throws ServiceException {
		try {
			clienteDao.deleteClienteById(id);
			LOGGER.info(String.format("Cliente ID: %d borrado exitosamente", id));
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
	}

	public Cliente getClienteById(long id) throws ServiceException {
		Cliente cliente = null;
		try {
			cliente = clienteDao.getClienteById(id);
			LOGGER.info("Cliente hallado exitosamente, Detalles=" + cliente.toString());
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return cliente;
	}

	public List<Cliente> getClientes() throws ServiceException{
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.getClientes();
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return clientes;
	}
}