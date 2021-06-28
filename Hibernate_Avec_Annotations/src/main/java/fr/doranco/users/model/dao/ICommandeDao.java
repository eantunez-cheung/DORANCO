package fr.doranco.users.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.users.entity.Commande;

public interface ICommandeDao extends IEntityFacade<Commande> {

	List<Commande> getListeCommandes1() throws Exception; //createNativeQuery
	List<Commande> getListeCommandes2() throws Exception; //createQuery
	List<Commande> getListeCommandes3() throws Exception; //createNamedQuery
	List<Commande> getListeCommandesById(Integer id) throws Exception; //createNamedQuery
	List<Commande> getListeCommandesByUtilisateurId(Integer utilisateurId) throws Exception; //createNamedQuery
	List<Commande> getListeCommandesByNom(String nom) throws Exception; //createNamedQuery
	List<Commande> getListeCommandesByVille(String ville) throws Exception; //createQuery
	Map<String, Integer> getNbCommandesByVille(String orderBy) throws Exception;//[par ordre croissant]
	Integer getNbCommandesOfVille(String ville) throws Exception;

}
