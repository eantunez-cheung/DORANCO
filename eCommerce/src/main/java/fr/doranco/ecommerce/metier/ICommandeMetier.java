package fr.doranco.ecommerce.metier;

import java.util.Date;
import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Commande;

public interface ICommandeMetier {

	void add(Commande commande) throws Exception;
	Commande getCommande(Integer id) throws Exception;
	Commande getCommandesByNumero(String numero) throws Exception;
	Set<Commande> getCommandes() throws Exception;
	Set<Commande> getCommandesByDateCreation(Date dateCreation) throws Exception;
	Set<Commande> getCommandesByUserId(Integer userId) throws Exception;
}
