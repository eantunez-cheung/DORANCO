package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.LigneDeCommande;
import fr.doranco.ecommerce.model.dao.ILigneDeCommandeDao;
import fr.doranco.ecommerce.model.dao.LigneDeCommandeDao;

public class LigneDeCommandeMetier implements ILigneDeCommandeMetier {

	ILigneDeCommandeDao ligneDeCommandeDao = new LigneDeCommandeDao();
	
	@Override
	public void add(LigneDeCommande ligneDeCommande) throws Exception {
		if (ligneDeCommande == null
				|| ligneDeCommande.getQuantite() == null || ligneDeCommande.getQuantite() <= 0
				|| ligneDeCommande.getPrixUnitaire() == null || ligneDeCommande.getPrixUnitaire() < 0
				|| ligneDeCommande.getRemiseArticle() == null || ligneDeCommande.getRemiseArticle() < 0) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls !\n"
					+ "Le paramètre 'quantite' doit être supérieur à 0 !\n"
					+ "Les paramètre 'prixUnitaire' et 'remiseArticle' doivent être prositifs !");
		}
		ligneDeCommandeDao.add(ligneDeCommande);
	}

	@Override
	public LigneDeCommande getLigneDeCommande(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		return ligneDeCommandeDao.get(LigneDeCommande.class, id);
	}

	@Override
	public Set<LigneDeCommande> getLignesDeCommande() throws Exception {
		return new HashSet<LigneDeCommande>(ligneDeCommandeDao.getAll(LigneDeCommande.class));
	}

}
