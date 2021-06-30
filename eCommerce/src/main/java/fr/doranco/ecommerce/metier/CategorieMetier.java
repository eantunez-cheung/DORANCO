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
			throw new IllegalArgumentException("Les param�tres doivent �tre non nuls !\n"
					+ "Le param�tre 'nom' doit �tre non vide et le param�tre 'remise' doit �tre positif !");
		}
		categorieDao.add(categorie);
	}

	@Override
	public Categorie getCategorie(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le param�tre 'id' doit �tre sup�rieur � 0 !");
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
			throw new IllegalArgumentException("Les param�tres doivent �tre non nuls !\n"
					+ "Le param�tre 'nom' doit �tre non vide et le param�tre 'remise' doit �tre positif !");
		}
		categorieDao.update(categorie);
	}

	@Override
	public void remove(Categorie categorie) throws Exception {
		if (categorie == null
				|| categorie.getNom() == null || categorie.getNom().trim().isEmpty()
				|| categorie.getRemise() == null || categorie.getRemise() < 0) {
			throw new IllegalArgumentException("Les param�tres doivent �tre non nuls !\n"
					+ "Le param�tre 'nom' doit �tre non vide et le param�tre 'remise' doit �tre positif !");
		}
		categorieDao.remove(categorie);
	}

}
