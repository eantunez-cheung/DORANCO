package fr.doranco.ecommerce.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseDao extends IEntityFacade<Adresse> {

	Set<Adresse> getAdressesByUserId(Integer userId) throws Exception;
	Set<Adresse> getAdressesByVille(String ville) throws Exception;
}
