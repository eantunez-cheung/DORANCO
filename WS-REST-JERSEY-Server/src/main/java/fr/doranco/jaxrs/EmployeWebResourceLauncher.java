package fr.doranco.jaxrs;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

public class EmployeWebResourceLauncher {

	public static URI BASE_URI = UriBuilder.fromUri("http://localhost/WS-REST/").port(9991).build();
	
	public static void main(String[] args) {
		try {
			ResourceConfig config = new PackagesResourceConfig("fr.doranco.jaxrs.jersey.server");
			System.out.println("Starting server : " + BASE_URI);
			HttpServer server = HttpServerFactory.create(BASE_URI, config);
			
			server.start();
			Thread.sleep(2000);
			System.out.println();
			System.err.println("  -> Jersey démarré avec succès.");
			System.err.println("  -> WADL disponible à l'adresse : " + BASE_URI);
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("  Pour tester si le web service est bien déployé, vérifiez le lien : "
					+ BASE_URI + "application.wadl");
			System.out.println("--------------------------------------------------");
			System.out.println();
			
//			System.in.read();
//			System.out.println("Arrêt du programme serveur en cours...");
//			server.stop(0);
//			Thread.sleep(2000);
//			System.err.println("Programme du serveur arrêté avec succès.");
			
			Thread.sleep(2000);
			System.err.println("Le serveur a démmaré avec succès");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
