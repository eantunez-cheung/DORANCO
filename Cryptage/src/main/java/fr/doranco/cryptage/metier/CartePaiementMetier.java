package fr.doranco.cryptage.metier;

import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.algo.CryptageDesPbeBlowfish;
import fr.doranco.cryptage.entity.dto.CartePaiementDto;
import fr.doranco.cryptage.entity.pojo.CartePaiement;
import fr.doranco.cryptage.entity.pojo.Utilisateur;
import fr.doranco.cryptage.enums.AlgorithmesCryptagePrincipal;
import fr.doranco.cryptage.model.dao.CartePaiementDAO;
import fr.doranco.cryptage.model.dao.ICartePaiementDAO;
import fr.doranco.cryptage.model.dao.IUserDAO;
import fr.doranco.cryptage.model.dao.UserDAO;
import fr.doranco.cryptage.utils.Dates;

public class CartePaiementMetier implements ICartePaiementMetier {

	private final ICartePaiementDAO cartePaiementDao = new CartePaiementDAO();
	private final IUserDAO userDao = new UserDAO();

	@Override
	public Set<CartePaiementDto> getCartePaiementByUserId(Integer userId) throws Exception {
		Set<CartePaiement> cartesPaiement = new HashSet<CartePaiement>();
		Set<CartePaiementDto> cartesPaiementDto = new HashSet<CartePaiementDto>();
		String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		Utilisateur user = userDao.getCleCryptage(userId);
		SecretKey key = new SecretKeySpec(user.getCleCryptage(), algo);
		cartesPaiement = cartePaiementDao.getCartePaiementByUserId(userId);
		for (CartePaiement cartePaiement : cartesPaiement) {
			String numero = CryptageDesPbeBlowfish.decrypt(algo, cartePaiement.getNumero(), key);
			String cryptogramme = CryptageDesPbeBlowfish.decrypt(algo, cartePaiement.getCryptogramme(), key);
			CartePaiementDto cartePaiementDto = new CartePaiementDto(cartePaiement.getTitulaire(),
																		numero,
																		Dates.convertDateUtilToString(cartePaiement.getDateValidite()),
																		cryptogramme);
			cartePaiementDto.setId(cartePaiement.getId().toString());
			cartesPaiementDto.add(cartePaiementDto);
		}
		return cartesPaiementDto;
	}

	@Override
	public CartePaiementDto addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception {
		CartePaiement cartePaiement = new CartePaiement();
		cartePaiement.setTitulaire(cartePaiementDto.getTitulaire());
		String algo = AlgorithmesCryptagePrincipal.DES.getAlgorithme();
		Utilisateur user = userDao.getCleCryptage(userId);
		SecretKey key = new SecretKeySpec(user.getCleCryptage(), algo);
		byte[] numeroCrypte = CryptageDesPbeBlowfish.encrypt(algo, cartePaiementDto.getNumero(), key);
		cartePaiement.setNumero(numeroCrypte);
		cartePaiement.setDateValidite(Dates.convertStringToDateUtil(cartePaiementDto.getDateValidite()));
		byte[] cryptogrammeCrypte = CryptageDesPbeBlowfish.encrypt(algo, cartePaiementDto.getCryptogramme(), key);
		cartePaiement.setCryptogramme(cryptogrammeCrypte);
		
		CartePaiement addedCartePaiement = cartePaiementDao.addCartePaiement(cartePaiement, userId);
		cartePaiementDto.setId(addedCartePaiement.getId().toString());
		return cartePaiementDto;
	}

}
