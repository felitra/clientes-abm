package com.fra.clientes.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;
import com.fra.clientes.services.exceptions.ClienteNotFoundException;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	private static final Logger LOGGER = Logger.getLogger(ClienteDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		LOGGER.info("Cliente almacenado exitosamente, Detalles= " + c.toString());
	}

	public void updateCliente(Cliente c) throws ClienteNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		if (session.get(Cliente.class, c.getId()) == null) {
			LOGGER.error(String.format("Cliente %d no encontrado", c.getId()));
			throw new ClienteNotFoundException();
		} else {
			session.merge(c);
			LOGGER.info("Cliente actualizado exitosamente, Detalles= " + c.toString());	
		}		
	}

	public void deleteClienteById(long id) throws ClienteNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.get(Cliente.class, new Long(id));
		if (c == null) {
			LOGGER.error(String.format("Cliente %d no encontrado", id));
			throw new ClienteNotFoundException();			
		} else {
			session.delete(c);
			LOGGER.info("Cliente borrado exitosamente, Detalles= " + c.toString());
		}
	}

	public Cliente getClienteById(long id) throws ClienteNotFoundException {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.get(Cliente.class, new Long(id));
		if (c == null) {
			LOGGER.error(String.format("Cliente %d no encontrado", id));
			throw new ClienteNotFoundException();
		} else {
			LOGGER.info("Cliente hallado exitosamente, Detalles=" + c.toString());
			return c;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> clientesList = session.createQuery("from Cliente").list();
		return clientesList;
	}

}
