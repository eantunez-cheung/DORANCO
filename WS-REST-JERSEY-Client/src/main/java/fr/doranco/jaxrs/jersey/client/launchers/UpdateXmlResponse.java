package fr.doranco.jaxrs.jersey.client.launchers;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import fr.doranco.jaxrs.jersey.entity.Employe;

public class UpdateXmlResponse {

	public static void main(String[] args) {
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:9991/WS-REST/employes/update");

		Builder builder = webResource.accept(MediaType.APPLICATION_XML).header("content-type",
				MediaType.APPLICATION_XML);

		Employe employe = new Employe("ANTUNEZ--CHEUNG", "Esteban", "Développeur");
		employe.setId(3);

		ClientResponse response = builder.put(ClientResponse.class, employe);
		
		if (response.getStatus() != 202) {
			System.out.println("Failed with HTTP Error code : " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error : "+ error);
			return;
		}
		
		System.out.println("Output from Server ....");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}
}
