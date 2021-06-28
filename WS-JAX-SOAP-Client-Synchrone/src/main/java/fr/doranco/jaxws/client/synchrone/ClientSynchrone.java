package fr.doranco.jaxws.client.synchrone;

import java.util.List;

import fr.doranco.jaxws.webservice.Etudiant;
import fr.doranco.jaxws.webservice.EtudiantService;
import fr.doranco.jaxws.webservice.EtudiantService_Service;

public class ClientSynchrone {

	public static void main(String[] args) {
		EtudiantService_Service service = new EtudiantService_Service();
		EtudiantService port = service.getEtudiantPort();

		Etudiant etudiantToAdd = new Etudiant();
		etudiantToAdd.setNom("REDFIELD");
		etudiantToAdd.setPrenom("Claire");
		etudiantToAdd.setSpecialite("D�veloppeur");
		;
		etudiantToAdd.setAge(35);

		Etudiant etudiantAdded = null;
		try {
			etudiantAdded = port.addEtudiant(etudiantToAdd);
			if (etudiantAdded.getId() != 0) {
				System.out.println("L'�tudiant a bien �t� ajout� : ");
				System.out.println("id : " + etudiantAdded.getId() + " nom : " + etudiantAdded.getNom() + " prenom : "
						+ etudiantAdded.getPrenom() + " sp�cialit� : " + etudiantAdded.getSpecialite() + " age : "
						+ etudiantAdded.getAge());
			} else {
				System.out.println("L'�tudiant n'a pas �t� ajout� !");
			}

			List<Etudiant> etudiants = port.getEtudiants();
			for (Etudiant student : etudiants) {
				System.out.println("id : " + student.getId() + " nom : " + student.getNom() + " prenom : "
						+ student.getPrenom() + " sp�cialit� : " + student.getSpecialite() + " age : "
						+ student.getAge());
			}

			Etudiant etudiant = port.getEtudiantById(14);
			System.out.println("id : " + etudiant.getId() + " nom : " + etudiant.getNom() + " prenom : "
					+ etudiant.getPrenom() + " sp�cialit� : " + etudiant.getSpecialite() + " age : "
					+ etudiant.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
