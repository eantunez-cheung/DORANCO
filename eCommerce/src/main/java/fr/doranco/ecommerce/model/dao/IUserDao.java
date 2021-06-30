package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.User;

public interface IUserDao extends IEntityFacade<User>{

	User getUserByEmail(String email) throws Exception;
	Map<String, Set<User>> getUsersByVille() throws Exception;
	List<User> getUsersOfVille(String ville) throws Exception;
	void disable(Integer id) throws Exception;
}
