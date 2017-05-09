package com.fra.clientes.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final String CLIENTE_NOT_FOUND_MESSAGE = "Cliente ID: %d no encontrado";

	public void addCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
	}

	public void updateCliente(Cliente c) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		if (session.get(Cliente.class, c.getId()) == null) {
			throw new SQLException(String.format(CLIENTE_NOT_FOUND_MESSAGE, c.getId()));
		} else {
			session.merge(c);
		}		
	}

	public void deleteClienteById(long id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.get(Cliente.class, new Long(id));
		if (c == null) {
			throw new SQLException(String.format(CLIENTE_NOT_FOUND_MESSAGE, id));
		} else {
			session.delete(c);
		}
	}

	public Cliente getClienteById(long id) throws SQLException {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.get(Cliente.class, new Long(id));
		if (c == null) {
			throw new SQLException(String.format(CLIENTE_NOT_FOUND_MESSAGE, id));
		} else {
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
