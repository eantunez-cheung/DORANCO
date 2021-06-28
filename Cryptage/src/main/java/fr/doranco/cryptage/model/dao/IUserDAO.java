package fr.doranco.cryptage.model.dao;

import fr.doranco.cryptage.entity.pojo.Utilisateur;

public interface IUserDAO {

	Utilisateur getUserByEmail(String email) throws Exception;
	Utilisateur addUser(Utilisateur user) throws Exception;
	Utilisateur getCleCryptage(Integer id) throws Exception;
}
