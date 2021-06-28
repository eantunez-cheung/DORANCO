package fr.doranco.rest.jersey.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import fr.doranco.rest.jersey.server.provider.AuthenticationFilter;

public class CustomApplication extends ResourceConfig {

	public CustomApplication() {
		packages("fr.doranco.rest.jersey.server.service");
		
		register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		
		register(AuthenticationFilter.class);
	}

	
}
