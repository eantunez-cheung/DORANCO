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
			throw new IllegalArgumentException("Les param�tres doivent �tre non nuls !\n"
					+ "Le param�tre 'quantite' doit �tre sup�rieur � 0 !\n"
					+ "Les param�tre 'prixUnitaire' et 'remiseArticle' doivent �tre prositifs !");
		}
		ligneDeCommandeDao.add(ligneDeCommande);
	}

	@Override
	public LigneDeCommande getLigneDeCommande(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le param�tre 'id' doit �tre sup�rieur � 0 !");
		}
		return ligneDeCommandeDao.get(LigneDeCommande.class, id);
	}

	@Override
	public Set<LigneDeCommande> getLignesDeCommande() throws Exception {
		return new HashSet<LigneDeCommande>(ligneDeCommandeDao.getAll(LigneDeCommande.class));
	}

}
