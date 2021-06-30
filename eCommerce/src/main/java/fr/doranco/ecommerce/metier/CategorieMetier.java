package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Categorie;
import fr.doranco.ecommerce.model.dao.CategorieDao;
import fr.doranco.ecommerce.model.dao.ICategorieDao;

public class CategorieMetier implements ICategorieMetier {

	private ICategorieDao categorieDao = new CategorieDao();
	
	@Override
	public void add(Categorie categorie) throws Exception {
		if (categorie == null
				|| categorie.getNom() == null || categorie.getNom().trim().isEmpty()
				|| categorie.getRemise() == null || categorie.getRemise() < 0) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls !\n"
					+ "Le paramètre 'nom' doit être non vide et le paramètre 'remise' doit être positif !");
		}
		categorieDao.add(categorie);
	}

	@Override
	public Categorie getCategorie(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		return categorieDao.get(Categorie.class, id);
	}

	@Override
	public Set<Categorie> getCategories() throws Exception {
		return new HashSet<Categorie>(categorieDao.getAll(Categorie.class));
	}

	@Override
	public void update(Categorie categorie) throws Exception {
		if (categorie == null
				|| categorie.getNom() == null || categorie.getNom().trim().isEmpty()
				|| categorie.getRemise() == null || categorie.getRemise() < 0) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls !\n"
					+ "Le paramètre 'nom' doit être non vide et le paramètre 'remise' doit être positif !");
		}
		categorieDao.update(categorie);
	}

	@Override
	public void remove(Categorie categorie) throws Exception {
		if (categorie == null
				|| categorie.getNom() == null || categorie.getNom().trim().isEmpty()
				|| categorie.getRemise() == null || categorie.getRemise() < 0) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls !\n"
					+ "Le paramètre 'nom' doit être non vide et le paramètre 'remise' doit être positif !");
		}
		categorieDao.remove(categorie);
	}

}
