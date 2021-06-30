package fr.doranco.ecommerce.model.dao;

import java.util.Date;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Commande;

public interface ICommandeDao extends IEntityFacade<Commande> {

	Commande getCommandesByNumero(String numero) throws Exception;
	Set<Commande> getCommandesByDateCreation(Date dateCreation) throws Exception;
	Set<Commande> getCommandesByUserId(Integer userId) throws Exception;
}
