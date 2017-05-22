package com.fra.clientes.spring.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.fra.clientes.dao")
public class PersistenceConfig {

	@Autowired
	public Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("clientes.abm.db.driver"));
		ds.setUrl(env.getProperty("clientes.abm.db.url"));
		ds.setUsername(env.getProperty("clientes.abm.db.username"));
		ds.setPassword(env.getProperty("clientes.abm.db.password"));
		return ds;
	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.fra.clientes.models");

		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect",
				env.getProperty("clientes.abm.hb.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql",
				env.getProperty("clientes.abm.hb.show_sql"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
				env.getProperty("clientes.abm.hb.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans",
				env.getProperty("clientes.abm.hb.enable_lazy_load_no_trans"));

		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.afterPropertiesSet();

		return sessionFactory.getObject();
	}

	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory());
		return transactionManager;
	}
}
