package fr.doranco.jaxws.main;

import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.EtudiantService;
import fr.doranco.jaxws.IEtudiantService;

public class Test {

	public static void main(String[] args) throws Exception {
		IEtudiantService etudiantService = new EtudiantService();
		
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("CAMUS");
		etudiant.setPrenom("Albert");
		etudiant.setSpecialite("écrivain");
		
		System.out.println("Test de la méthode d'ajout d'un étudiant : " + etudiant);
		Etudiant etudiantAdded = etudiantService.addEtudiant(etudiant);
		
		if (etudiantAdded.getId() != 0) {
			System.out.println("L'étudiant a bien été ajouté : " + etudiantAdded);
		} else {
			System.out.println("L'étudiant n'a pas été ajouté !");
		}
		
		etudiant = new Etudiant();
		etudiant.setNom("HUGO");
		etudiant.setPrenom("Victor");
		etudiant.setSpecialite("romancier");
		
		System.out.println();
		System.out.println("Test de la méthode d'ajout d'un étudiant : " + etudiant);
		etudiantAdded = etudiantService.addEtudiant(etudiant);
		
		if (etudiantAdded.getId() != 0) {
			System.out.println("L'étudiant a bien été ajouté : " + etudiantAdded);
		} else {
			System.out.println("L'étudiant n'a pas été ajouté !");
		}
		
		System.out.println();
		System.out.println("Test de la méthode de récupération de tous les étudiants :");
		List<Etudiant> listEtudiants = etudiantService.getEtudiants();
		for (Etudiant student : listEtudiants) {
			System.out.println(student);
		}
	}
}
