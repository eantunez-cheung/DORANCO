package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseMetier {

	void add(Adresse adresse) throws Exception;
	Adresse getAdresse(Integer id) throws Exception;
	Set<Adresse> getAdresses() throws Exception;
	Set<Adresse> getAdressesByUserId(Integer userId) throws Exception;
	Set<Adresse> getAdressesByVille(String ville) throws Exception;
	void update(Adresse adresse) throws Exception;
	void remove(Adresse adresse) throws Exception;
	
}
