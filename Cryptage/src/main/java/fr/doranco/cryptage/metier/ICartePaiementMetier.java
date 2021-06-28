package fr.doranco.cryptage.metier;

import java.util.Set;

import fr.doranco.cryptage.entity.dto.CartePaiementDto;

public interface ICartePaiementMetier {

	Set<CartePaiementDto> getCartePaiementByUserId(Integer userId) throws Exception;
	CartePaiementDto addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception;
}
