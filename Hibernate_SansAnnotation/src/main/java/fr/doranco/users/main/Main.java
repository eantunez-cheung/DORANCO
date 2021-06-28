package fr.doranco.users.main;

import fr.doranco.users.entity.Adresse;
import fr.doranco.users.entity.Personne;
import fr.doranco.users.model.dao.IPersonneDao;
import fr.doranco.users.model.dao.PersonneDao;
import fr.doranco.users.utils.Dates;

public class Main {

	public static void main(String[] args) {
		try {
			Adresse adresse = new Adresse(7, "Rue Blaise Pascal", "Paris", "75000");
			Personne personne = new Personne("HUGO", "Victor", Dates.convertStringToDateUtil("24/11/1940"));
			personne.setAdresse(adresse);
			IPersonneDao personneDao = new PersonneDao();
			personneDao.addPersonne(personne);
			System.out.println(personne);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		
	}
}
