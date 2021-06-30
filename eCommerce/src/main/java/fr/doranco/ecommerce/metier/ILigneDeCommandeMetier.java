package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.LigneDeCommande;

public interface ILigneDeCommandeMetier {

	void add(LigneDeCommande ligneDeCommande) throws Exception;
	LigneDeCommande getLigneDeCommande(Integer id) throws Exception;
	Set<LigneDeCommande> getLignesDeCommande() throws Exception;
}
