package fr.doranco.ecommerce.metier;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.doranco.ecommerce.entity.dto.UserDto;

public interface IUserMetier {

	void add(UserDto user) throws Exception;
	UserDto getUser(Integer id) throws Exception;
	Set<UserDto> getUsers() throws Exception;
	void update(UserDto user) throws Exception;
	void remove(Integer id) throws Exception;
	
	UserDto getUserByEmail(String email) throws Exception;
	Map<String, Set<UserDto>> getUsersByVille() throws Exception;
	List<UserDto> getUsersOfVille(String ville) throws Exception;
}
