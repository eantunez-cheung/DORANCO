package fr.doranco.filrouge.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.filrouge.entity.Utilisateur;

public class UpdateJsonToResponse {

	private final static String BASE_URI = "http://localhost:9991/rest/";
	
	public static void main(String[] args) {
		
		Utilisateur user = new Utilisateur("CARTILLIER", "Bérénice");
		user.setId(3);
		
		/*
		 * Ici, on appelle le webService update par défaut (qui n'a pas de path)
		 */
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target(BASE_URI).path("users");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON); // request => type de réponse
		Response response = builder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() == 202) {
			Utilisateur updatedUser = response.readEntity(Utilisateur.class);
			System.out.println(updatedUser);
		} else {
			String message = response.readEntity(String.class);
			System.out.println("code status = " + response.getStatus());
			System.out.println(response.getStatusInfo());
			System.out.println(message);
		}
		
		/*
		 * Ici, on appelle le webService update selon un path précis
		 */

		webTarget = client.target(BASE_URI).path("users").path("updatePrenom/3/Bérénice");
		builder = webTarget.request(MediaType.APPLICATION_JSON); // request => type de réponse
		response = builder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() == 202) {
			Utilisateur updatedUser = response.readEntity(Utilisateur.class);
			System.out.println(updatedUser);
		} else {
			String message = response.readEntity(String.class);
			System.out.println("code status = " + response.getStatus());
			System.out.println(response.getStatusInfo());
			System.out.println(message);
		}

	}
}
