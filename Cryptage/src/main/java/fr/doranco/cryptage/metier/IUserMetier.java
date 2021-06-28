package fr.doranco.cryptage.metier;

import fr.doranco.cryptage.entity.dto.UtilisateurDto;

public interface IUserMetier {

	boolean seConnecter(String email, String password) throws Exception;
	UtilisateurDto addUser(UtilisateurDto userDto) throws Exception;
}
