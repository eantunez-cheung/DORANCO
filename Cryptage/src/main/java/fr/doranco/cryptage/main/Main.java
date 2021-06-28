package fr.doranco.cryptage.main;

import java.util.Set;

import fr.doranco.cryptage.entity.dto.CartePaiementDto;
import fr.doranco.cryptage.entity.dto.UtilisateurDto;
import fr.doranco.cryptage.metier.CartePaiementMetier;
import fr.doranco.cryptage.metier.ICartePaiementMetier;
import fr.doranco.cryptage.metier.IUserMetier;
import fr.doranco.cryptage.metier.UserMetier;

public class Main {

	public static void main(String[] args) {

		IUserMetier userMetier = new UserMetier();
		
		UtilisateurDto userDto = new UtilisateurDto("HUGO", "Victor", "victor@gmail.com", "victorpass");
		UtilisateurDto addedUserDto = null;
		try {
			 addedUserDto = userMetier.addUser(userDto);
			 System.out.println(addedUserDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			boolean isConnected = userMetier.seConnecter(userDto.getEmail(), userDto.getPassword());
			if (isConnected) {
				System.out.println("L'utilisateur " + userDto.getNom() + " " + userDto.getPrenom() + " : connecté");
			} else {
				System.out.println("L'utilisateur " + userDto.getNom() + " " + userDto.getPrenom()
						+ " : Email et/ou Mote de passe incorrects !");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ICartePaiementMetier cartePaiementMetier = new CartePaiementMetier();
		CartePaiementDto cpDto1 = new CartePaiementDto("Victor HUGO", "1234567812345678", "01/09/2022", "345");
		CartePaiementDto cpDto2 = new CartePaiementDto("Albert CAMUS", "9876543298765432", "01/04/2022", "657");
		Integer idUser = new Integer(addedUserDto.getId());
		
		try {
			CartePaiementDto addedCpDto1 = cartePaiementMetier.addCartePaiement(cpDto1, idUser);
			CartePaiementDto addedCpDto2 = cartePaiementMetier.addCartePaiement(cpDto2, idUser);
			System.out.println(addedCpDto1);
			System.out.println(addedCpDto2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------------------------------------------------------");
		Set<CartePaiementDto> cartesPaiement = null;
		try {
			cartesPaiement = cartePaiementMetier.getCartePaiementByUserId(idUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cartesPaiement.forEach(cp -> System.out.println(cp));
	}

}
