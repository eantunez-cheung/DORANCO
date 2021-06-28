package fr.doranco.users.main;

import fr.doranco.users.model.dao.CommandeDao;
import fr.doranco.users.model.dao.ICommandeDao;
import fr.doranco.users.model.dao.IUserDao;
import fr.doranco.users.model.dao.UserDao;

public class Main {

	public static void main(String[] args) {
		IUserDao userDao = new UserDao();
		ICommandeDao commandeDao = new CommandeDao();
		try {
//			User user = new User("CAMUS", "Albert", "camus@gmail.com", Dates.convertStringToDateUtil("27/11/1940"), "camus_a", "1234");
//			userDao.add(user);
//			System.out.println(user);
//			System.out.println("=================================================");
//			
//			Adresse adresse = new Adresse(12, "Rue Lafayette", "Paris", "75000");
//			Adresse adresse1 = new Adresse(6, "Boulevard Blaise Pascal", "Lyon", "69000");
//			User user1 = new User("HUGO", "Victor", "victor@gmail.com", Dates.convertStringToDateUtil("18/06/1940"),"hugo_v", "4567");
//			adresse.setUser(user1);
//			adresse1.setUser(user1);
//			user1.getAdresses().add(adresse);
//			user1.getAdresses().add(adresse1);
//			
//			userDao.add(user1);
//			
//			System.out.println(user1);
//			System.out.println("=================================================");
			
			System.out.println(userDao.getUsersOfVille("Paris"));
//			System.out.println("=================================================");
			
//			System.out.println("méthode 1 :");
//			System.out.println(commandeDao.getListeCommandesById(1));
//			System.out.println("=================================================");
//			System.out.println("méthode 2 :");
//			System.out.println(commandeDao.getListeCommandesByUtilisateurId(2));
//			System.out.println("=================================================");
//			System.out.println("méthode 3 :");
			System.out.println(commandeDao.getNbCommandesByVille("commande"));
//			System.out.println("=================================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
