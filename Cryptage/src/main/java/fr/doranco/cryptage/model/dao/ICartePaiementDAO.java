package fr.doranco.cryptage.model.dao;

import java.util.Set;

import fr.doranco.cryptage.entity.pojo.CartePaiement;

public interface ICartePaiementDAO {

	Set<CartePaiement> getCartePaiementByUserId(Integer userId) throws Exception;
	CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception;
}
