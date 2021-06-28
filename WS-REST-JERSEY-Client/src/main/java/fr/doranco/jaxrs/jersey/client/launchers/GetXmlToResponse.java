package fr.doranco.jaxrs.jersey.client.launchers;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class GetXmlToResponse {

	public static void main(String[] args) {
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:9991/WS-REST/employes/employe-123");
		
		Builder builder = webResource.accept(MediaType.APPLICATION_XML)
				.header("content-type", MediaType.APPLICATION_XML);
		
		ClientResponse response = builder.get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP Error code : " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error : " + error);
			return;
		}
		
		String output = response.getEntity(String.class);
		System.out.println("code status : " + response.getStatus() + " (OK)");
		System.out.println("'Output from Server ....");
		System.out.println(output);
	}
}
