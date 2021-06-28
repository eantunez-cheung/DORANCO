package fr.doranco.filrouge.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.filrouge.entity.Utilisateur;

public class GetJsonToResponse {

	private final static String BASE_URI = "http://localhost:9991/rest/";
	public static void main(String[] args) {
		
		//Client client = ClientBuilder.newClient();
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target(BASE_URI).path("users").path("get/5");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		
		if (response.getStatus() == 200) {
			Utilisateur user = response.readEntity(Utilisateur.class);
			System.out.println(user);
		} else {
			String message = response.readEntity(String.class);
			System.out.println("code status = " + response.getStatus());
			System.out.println(response.getStatusInfo());
			System.out.println(message);
		}
	}
}
