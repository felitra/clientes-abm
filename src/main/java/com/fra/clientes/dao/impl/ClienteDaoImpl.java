package com.fra.clientes.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fra.clientes.dao.ClienteDao;
import com.fra.clientes.models.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	//
	// private static final Logger logger = LoggerFactory
	// .getLogger(ClienteDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
//		logger.info("Cliente almacenado exitosamente, Detalles= "
//				+ c.toString());
	}

	public void updateCliente(Cliente c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
//		logger.info("Cliente actualizado exitosamente, Detalles= "
//				+ c.toString());
	}

	public void removeCliente(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.load(Cliente.class, new Long(id));
		if (null != c) {
			session.delete(c);
		}
//		logger.info("Cliente borrado exitosamente, Detalles= " + c.toString());
	}

	public Cliente getClienteById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente c = (Cliente) session.load(Cliente.class, new Long(id));
//		logger.info("Cliente hallado exitosamente, Detalles=" + c.toString());
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> clientesList = session.createQuery("from Cliente").list();
		return clientesList;
	}

}
