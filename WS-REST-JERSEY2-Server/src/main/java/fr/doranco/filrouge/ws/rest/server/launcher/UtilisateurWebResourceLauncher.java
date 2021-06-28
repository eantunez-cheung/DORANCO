package fr.doranco.filrouge.ws.rest.server.launcher;

import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import fr.doranco.filrouge.ws.rest.server.UtilisateurWebResource;

public class UtilisateurWebResourceLauncher {

	private static final URI BASE_URI = UriBuilder.fromUri("http://localhost/rest/").port(9991).build();
	
	public static void main(String[] args) {

		//Plusieurs façons (librairies) de démarrer un serveur de webServices REST :
		// - utiliser "Grizzly HTTP server" (jersey-container-grizzly2-http)
		// - utiliser "JDK HTTP Server" (jersey-container-jdk-http)
		// - utiliser "Simple Server" (jersey-container-simple-http)
		// - utiliser "Jetty HTTP Server" (jersey-container-jetty-http)
		// - utiliser "Netty HTTP Server" (jersey-container-netty-http)

		try {
			// Ici on va utiliser "Grizzly HTTP server" (jersey-container-grizzly2-http)
			ResourceConfig config = new ResourceConfig();
			config.register(UtilisateurWebResource.class);
//			config.register(UtilisateurWebResource2.class);
//			config.register(UtilisateurWebResource3.class);
			HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
			server.start();
			
			Thread.sleep(2000);
			System.out.println("");
			System.out.println("  => Jersey server démarré avec succès.");
			System.out.println("  => WADL disponible à l'adresse : " + BASE_URI);
			System.out.println("---------------------------------------------------------------------");
			System.out.println("  => Pour tester si le webService est bien déployé, vérifiez l'URL suivante :");
			System.out.println("        " + BASE_URI + "application.wadl");
			System.out.println("---------------------------------------------------------------------");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
