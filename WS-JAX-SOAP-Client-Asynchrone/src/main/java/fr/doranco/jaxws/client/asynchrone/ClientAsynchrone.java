package fr.doranco.jaxws.client.asynchrone;

import java.util.concurrent.ExecutionException;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import fr.doranco.jaxws.webservice.AddEtudiantResponse;
import fr.doranco.jaxws.webservice.Etudiant;
import fr.doranco.jaxws.webservice.EtudiantService;
import fr.doranco.jaxws.webservice.EtudiantService_Service;

public class ClientAsynchrone {

	public static void main(String[] args) {
		EtudiantService_Service service = new EtudiantService_Service();
		EtudiantService port = service.getEtudiantPort();
		
		Etudiant etudiantToAdd = new Etudiant();
		etudiantToAdd.setNom("SMITH");
		etudiantToAdd.setPrenom("Paul");
		etudiantToAdd.setSpecialite("Mécanique");;
		etudiantToAdd.setAge(35);
		
		/*
		 * Asynchronous with callback handler (event)
		 */
		AsyncHandler<AddEtudiantResponse> asyncHandler = new AsyncHandler<AddEtudiantResponse>() {
			@Override
			public void handleResponse(Response<AddEtudiantResponse> res) {
				System.out.println("  -> int handleResponse");
				if (!res.isCancelled() && res.isDone()) {
					try {
						Etudiant etudiantAdded = res.get().getReturn();
						System.out.println("  -> Etudiant ajouté : " + etudiantAdded);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		};
		System.out.println("  -> Appel de la méthode distante 'addEtudiant' with callback");
		port.addEtudiantAsync(etudiantToAdd, asyncHandler);
		System.out.println("  -> Appel effectué with callback");
		
		/*
		 * Asynchronous with polling mode ()
		 */
		try {
			System.out.println("  => Appel de la méthode distante 'addEtudiant' with polling");
			Response<AddEtudiantResponse> resp = port.addEtudiantAsync(etudiantToAdd);
			Thread.sleep(2000L);
			AddEtudiantResponse output = resp.get();
			System.out.println("  => Etudiant ajouté : " + output.getReturn());
		} catch (Exception exc) {
			System.out.println(exc.getClass().getName() + " => polling for response : " + exc.getMessage());
		}
	}
}
