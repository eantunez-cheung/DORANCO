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

public class AddJsonToResponse {

	private final static String BASE_URI = "http://localhost:9991/rest/";
	public static void main(String[] args) {
		
		Utilisateur user = new Utilisateur("CARTILLIER", "Bérénice");
		
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target(BASE_URI).path("users");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON); // request => type de réponse
		Response response = builder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() == 201) {
			Utilisateur addedUser = response.readEntity(Utilisateur.class);
			System.out.println(addedUser);
		} else {
			String message = response.readEntity(String.class);
			System.out.println("code status = " + response.getStatus());
			System.out.println(response.getStatusInfo());
			System.out.println(message);
		}
	}
}
