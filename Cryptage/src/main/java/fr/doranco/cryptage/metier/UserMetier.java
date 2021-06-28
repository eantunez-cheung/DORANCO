package fr.doranco.cryptage.metier;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.algo.CryptageDesPbeBlowfish;
import fr.doranco.cryptage.algo.GenerateKey;
import fr.doranco.cryptage.entity.dto.UtilisateurDto;
import fr.doranco.cryptage.entity.pojo.Utilisateur;
import fr.doranco.cryptage.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.cryptage.model.dao.IUserDAO;
import fr.doranco.cryptage.model.dao.UserDAO;

public class UserMetier implements IUserMetier {

	private final IUserDAO userDao = new UserDAO();
	
	@Override
	public boolean seConnecter(String email, String password) throws Exception {
		
		Utilisateur user = userDao.getUserByEmail(email);
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		SecretKey cleCryptage = new SecretKeySpec(user.getCleCryptage(), algorithm);
		byte[] passwordCrypte = user.getPassword();
		String passwordDecrypte = CryptageDesPbeBlowfish.decrypt(algorithm, passwordCrypte, cleCryptage);
		
		return password.equals(passwordDecrypte);
	}

	@Override
	public UtilisateurDto addUser(UtilisateurDto userDto) throws Exception {
		
		Utilisateur user = new Utilisateur();
		user.setNom(userDto.getNom().toUpperCase());
		user.setPrenom(userDto.getPrenom().toLowerCase());
		user.setEmail(userDto.getEmail());
		
		String algorithm = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		SecretKey cleCryptage = GenerateKey.getKey(algorithm, 56);
		byte[] cleCryptageBytes = cleCryptage.getEncoded();
		user.setCleCryptage(cleCryptageBytes);
		
		byte[] password = CryptageDesPbeBlowfish.encrypt(algorithm, userDto.getPassword(), cleCryptage);
		user.setPassword(password);

		Utilisateur addedUser = userDao.addUser(user);
		userDto.setId(addedUser.getId().toString());
		
		return userDto;
	}

}
