package fr.doranco.ecommerce.metier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.ecommerce.cryptage.Cryptage;
import fr.doranco.ecommerce.entity.beans.Params;
import fr.doranco.ecommerce.entity.beans.User;
import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.IUserDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UserDao;
import fr.doranco.ecommerce.utils.Dates;

public class UserMetier implements IUserMetier {

	private IUserDao userDao = new UserDao();
	private IParamsDao paramsDao = new ParamsDao();

	@Override
	public void add(UserDto user) throws Exception {
		if (user == null
				|| user.getNom() == null || user.getNom().trim().isEmpty()
				|| user.getPrenom() == null || user.getPrenom().trim().isEmpty()
				|| user.getDateNaissance() == null || user.getDateNaissance().trim().isEmpty()
				|| user.getProfil() == null || user.getProfil().trim().isEmpty()
				|| user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}
		
		String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		Params params = paramsDao.get(Params.class, 1);
		SecretKey key = new SecretKeySpec(params.getCleCryptage(), algo);
		byte[] password = Cryptage.encrypt(algo, user.getPassword(), key);
		
		User userToAdd = new User();
		userToAdd.setNom(user.getNom());
		userToAdd.setPrenom(user.getPrenom());
		userToAdd.setDateNaissance(Dates.convertStringToDateUtil(user.getDateNaissance()));
		userToAdd.setProfil(user.getProfil());
		userToAdd.setEmail(user.getEmail());
		userToAdd.setPassword(password);
		userToAdd.setTelephone(user.getTelephone());
		
		userDao.add(userToAdd);
	}

	@Override
	public UserDto getUser(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		
		
		User user = userDao.get(User.class, id);
		UserDto userDto = new UserDto();
		userDto.setNom(user.getNom());
		userDto.setPrenom(user.getPrenom());
		userDto.setDateNaissance(Dates.convertDateUtilToString(user.getDateNaissance()));
		userDto.setProfil(user.getProfil());
		userDto.setEmail(user.getEmail());
		userDto.setTelephone(user.getTelephone());
		return userDto;
	}

	@Override
	public Set<UserDto> getUsers() throws Exception {
		Set<User> users = new HashSet<User>(userDao.getAll(User.class));
		Set<UserDto> usersDto = new HashSet<UserDto>();
		
		
		for (User user : users) {
			UserDto userDto = new UserDto();
			userDto.setNom(user.getNom());
			userDto.setPrenom(user.getPrenom());
			userDto.setDateNaissance(Dates.convertDateUtilToString(user.getDateNaissance()));
			userDto.setProfil(user.getProfil());
			userDto.setEmail(user.getEmail());
			userDto.setTelephone(user.getTelephone());
			usersDto.add(userDto);
		}
		return usersDto;
	}

	@Override
	public void update(UserDto user) throws Exception {
		if (user == null
				|| user.getNom() == null || user.getNom().trim().isEmpty()
				|| user.getPrenom() == null || user.getPrenom().trim().isEmpty()
				|| user.getDateNaissance() == null || user.getDateNaissance().trim().isEmpty()
				|| user.getProfil() == null || user.getProfil().trim().isEmpty()
				|| user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null || user.getPassword().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}
		
		String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		Params params = paramsDao.get(Params.class, 1);
		SecretKey key = new SecretKeySpec(params.getCleCryptage(), algo);
		byte[] password = Cryptage.encrypt(algo, user.getPassword(), key);
		
		User userToUpdate = new User();
		userToUpdate.setId(Integer.valueOf(user.getId()));
		userToUpdate.setNom(user.getNom());
		userToUpdate.setPrenom(user.getPrenom());
		userToUpdate.setDateNaissance(Dates.convertStringToDateUtil(user.getDateNaissance()));
		userToUpdate.setProfil(user.getProfil());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(password);
		userToUpdate.setTelephone(user.getTelephone());
		userDao.update(userToUpdate);
	}

	@Override
	public void remove(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		userDao.disable(id);
	}

	@Override
	public UserDto getUserByEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'email' doit être non nul et non vide !");
		}
		
		User user = userDao.getUserByEmail(email);
		UserDto userDto = new UserDto();
		userDto.setNom(user.getNom());
		userDto.setPrenom(user.getPrenom());
		userDto.setDateNaissance(Dates.convertDateUtilToString(user.getDateNaissance()));
		userDto.setProfil(user.getProfil());
		userDto.setEmail(user.getEmail());
		userDto.setTelephone(user.getTelephone());
		
		return userDto;
	}

	@Override
	public Map<String, Set<UserDto>> getUsersByVille() throws Exception {
//		Map<String, Set<User>> usersByVille = userDao.getUsersByVille();
//		Map<String, Set<UserDto>> usersDtoByville = new HashMap<String, Set<UserDto>>();
		return null;
	}

	@Override
	public List<UserDto> getUsersOfVille(String ville) throws Exception {
		List<UserDto> usersDtoOfVille = new ArrayList<UserDto>();
		List<User> usersOfVille = userDao.getUsersOfVille(ville);
		
		for (User user : usersOfVille) {
			UserDto userDto = new UserDto();
			userDto.setNom(user.getNom());
			userDto.setPrenom(user.getPrenom());
			userDto.setDateNaissance(Dates.convertDateUtilToString(user.getDateNaissance()));
			userDto.setProfil(user.getProfil());
			userDto.setEmail(user.getEmail());
			userDto.setTelephone(user.getTelephone());
			usersDtoOfVille.add(userDto);
		}
		return usersDtoOfVille;
	}
	

}
