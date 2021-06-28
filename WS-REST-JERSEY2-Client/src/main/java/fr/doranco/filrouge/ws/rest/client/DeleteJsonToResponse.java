package fr.doranco.filrouge.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

public class DeleteJsonToResponse {

	private final static String BASE_URI = "http://localhost:9991/rest/";
	public static void main(String[] args) {
		
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target(BASE_URI).path("users").path("delete/8");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON); // request => type de réponse
		Response response = builder.delete();
		
		String message = response.readEntity(String.class);
		if (response.getStatus() == 202) {
			System.out.println("suppression réussie.");
		} else {
			System.out.println("Erreur lors de la suppression !");
			System.out.println("code status = " + response.getStatus());
			System.out.println(response.getStatusInfo());
		}
		System.out.println(message);
	}
}
