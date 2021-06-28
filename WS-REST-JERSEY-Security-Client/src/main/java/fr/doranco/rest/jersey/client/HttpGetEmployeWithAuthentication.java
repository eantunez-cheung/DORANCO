package fr.doranco.rest.jersey.client;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.doranco.rest.beans.Employe;

public class HttpGetEmployeWithAuthentication {

	public static void main(String[] args) {
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive()
				.credentials("toto", "titi").build();
		
		ClientConfig config = new ClientConfig();
		config.register(feature);
		config.register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget webTarget = client.target("http://127.0.0.1:8080/WS-REST-JERSEY-Security-Server/rest/")
									.path("employes")
									.path("get-5");
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		String credentials = "toto::titi";
		String encodedUsernameAndPassword = Base64.getEncoder().encodeToString(credentials.getBytes());
		
		Response response = builder.header("Authorization", encodedUsernameAndPassword)
									.header("Filiale", "SAS TECHNO::BLABLA::BLOBLO::BLIBLI")
									.get();

		Employe employe = response.readEntity(Employe.class);
		System.out.println(employe);
	}
}
