package fr.doranco.filrouge.ws.rest.server;

import java.util.List;

import javax.ws.rs.core.Response;

import fr.doranco.filrouge.entity.Utilisateur;

public interface IUtilisateurWebResource {

	String CHARSET = ";charset=UTF-8";
	
	String getInfos();
	Response getUtilisateur(Integer id);
	Response addUtilisateur(Utilisateur utilisateur);
	Response addUtilisateurs(List<Utilisateur> utilisateurs);
	Response updateUtilisateur(Utilisateur utilisateur);
	Response updateUtilisateurPrenom(Integer id, String prenom);
	Response removeUtilisateur(Integer id);
	
}
