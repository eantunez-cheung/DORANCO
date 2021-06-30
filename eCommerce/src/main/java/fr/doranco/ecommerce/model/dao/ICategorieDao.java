package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.beans.Categorie;

public interface ICategorieDao extends IEntityFacade<Categorie> {

	Categorie getCategorieByNom(String nom) throws Exception;
}
