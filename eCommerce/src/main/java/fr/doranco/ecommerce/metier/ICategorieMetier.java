package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Categorie;

public interface ICategorieMetier {

	void add(Categorie categorie) throws Exception;
	Categorie getCategorie(Integer id) throws Exception;
	Set<Categorie> getCategories() throws Exception;
	void update(Categorie categorie) throws Exception;
	void remove(Categorie categorie) throws Exception;
}
