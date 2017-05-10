package com.fra.clientes.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("file:/apps/clientes-abm/clientes-abm.properties")
//TODO: Restringir el escaneo despues de arreglar el controller web com.fra.clientes.services
@ComponentScan("com.fra.clientes")
@Import(PersistenceConfig.class)
public class MainConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
