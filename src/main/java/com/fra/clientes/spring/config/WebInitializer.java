package com.fra.clientes.config;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.util.Log4jConfigurer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();

		String[] configLocations = { "/WEB-INF/dispatcher-servlet.xml", "/WEB-INF/applicationResources.xml" };
		appContext.setConfigLocations(configLocations);

		container.addListener(Log4jConfigListener.class);
		try {
			Log4jConfigurer.initLogging("file:/apps/clientes-abm/log4j-clientes.properties", 300000);
		} catch (FileNotFoundException e) {
			System.out.println("Log4j properties file not found");
		}
				
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		      		
				/*		Proxima configuracion
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MainConfiguration.class);
		
		container.setInitParameter("log4jConfiguration", "file:/apps/clientes-abm/log4j-clientes.properties");
		container.addListener(Log4jConfigListener.class);
		
		
		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		*/
	}
}
