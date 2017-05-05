package com.fra.clientes.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Clase necesaria por conveniencia (Default).
 * 
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.fra.clientes.rest.controller")
public class RestConfig {
}
