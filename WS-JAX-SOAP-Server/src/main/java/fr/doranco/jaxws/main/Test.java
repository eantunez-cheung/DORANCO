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
		etudiant.setSpecialite("�crivain");
		
		System.out.println("Test de la m�thode d'ajout d'un �tudiant : " + etudiant);
		Etudiant etudiantAdded = etudiantService.addEtudiant(etudiant);
		
		if (etudiantAdded.getId() != 0) {
			System.out.println("L'�tudiant a bien �t� ajout� : " + etudiantAdded);
		} else {
			System.out.println("L'�tudiant n'a pas �t� ajout� !");
		}
		
		etudiant = new Etudiant();
		etudiant.setNom("HUGO");
		etudiant.setPrenom("Victor");
		etudiant.setSpecialite("romancier");
		
		System.out.println();
		System.out.println("Test de la m�thode d'ajout d'un �tudiant : " + etudiant);
		etudiantAdded = etudiantService.addEtudiant(etudiant);
		
		if (etudiantAdded.getId() != 0) {
			System.out.println("L'�tudiant a bien �t� ajout� : " + etudiantAdded);
		} else {
			System.out.println("L'�tudiant n'a pas �t� ajout� !");
		}
		
		System.out.println();
		System.out.println("Test de la m�thode de r�cup�ration de tous les �tudiants :");
		List<Etudiant> listEtudiants = etudiantService.getEtudiants();
		for (Etudiant student : listEtudiants) {
			System.out.println(student);
		}
	}
}
