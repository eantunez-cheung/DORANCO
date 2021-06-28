package fr.doranco.users.model.dao;

import fr.doranco.users.entity.Personne;

public interface IPersonneDao {

	void addPersonne(Personne personne) throws Exception;
	Personne getPersonne(Integer id) throws Exception;
	void updatePersonne(Personne personne) throws Exception;
	void removePersonne(Personne personne) throws Exception;
}
