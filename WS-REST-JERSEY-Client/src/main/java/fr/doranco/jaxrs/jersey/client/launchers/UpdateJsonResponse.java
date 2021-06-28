package fr.doranco.jaxrs.jersey.client.launchers;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

import fr.doranco.jaxrs.jersey.entity.Employe;

public class UpdateJsonResponse {

	public static void main(String[] args) {
		Client client = Client.create();

		WebResource webResourceGet = client.resource("http://localhost:9991/WS-REST/employes/employe-3");
		
		Builder builderGet = webResourceGet.accept(MediaType.APPLICATION_JSON).header("content-type",
				MediaType.APPLICATION_JSON);
		
		ClientResponse responseGet = builderGet.get(ClientResponse.class);
		
		if (responseGet.getStatus() != 200) {
			System.out.println("Failed with HTTP Error code : " + responseGet.getStatus());
			String error = responseGet.getEntity(String.class);
			System.out.println("Error : "+ error);
			System.exit(1);
		}
		Employe employe = responseGet.getEntity(Employe.class);
		employe.setPosteOccupe("Concepteur");
		
		WebResource webResourcePut = client.resource("http://localhost:9991/WS-REST/employes/update");

		Builder builderPut = webResourcePut.accept(MediaType.APPLICATION_JSON).header("content-type",
				MediaType.APPLICATION_JSON);

		ClientResponse response = builderPut.put(ClientResponse.class, employe);
		
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
