package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;

public interface ICartePaiementMetier {

	void add(CartePaiementDto cartePaiementDto) throws Exception;
	CartePaiementDto getCartepaiementDto(Integer id) throws Exception;
	Set<CartePaiementDto> getCartespaiementDto() throws Exception;
	void remove(CartePaiementDto cartePaiementDto) throws Exception;
}
