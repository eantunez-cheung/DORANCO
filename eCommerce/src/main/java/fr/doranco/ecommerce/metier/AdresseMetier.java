package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Adresse;
import fr.doranco.ecommerce.model.dao.AdresseDao;
import fr.doranco.ecommerce.model.dao.IAdresseDao;

public class AdresseMetier implements IAdresseMetier {

	private IAdresseDao adresseDao = new AdresseDao();
	
	@Override
	public void add(Adresse adresse) throws Exception {
		if (adresse == null
				|| adresse.getNumero() == null || adresse.getNumero() <= 0
				|| adresse.getRue() == null || adresse.getRue().trim().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().trim().isEmpty()
				|| adresse.getCodePostal() == null || adresse.getCodePostal().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}
		adresseDao.add(adresse);
	}

	@Override
	public Adresse getAdresse(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		return adresseDao.get(Adresse.class, id);
	}

	@Override
	public Set<Adresse> getAdresses() throws Exception {
		return new HashSet<Adresse>(adresseDao.getAll(Adresse.class));
	}

	@Override
	public Set<Adresse> getAdressesByUserId(Integer userId) throws Exception {
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("Le paramètre 'userId' doit être supérieur à 0 !");
		}
		return adresseDao.getAdressesByUserId(userId);
	}

	@Override
	public Set<Adresse> getAdressesByVille(String ville) throws Exception {
		if (ville == null || ville.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'ville' doit être non nul et non vide !");
		}
		return adresseDao.getAdressesByVille(ville);
	}

	@Override
	public void update(Adresse adresse) throws Exception {
		if (adresse == null
				|| adresse.getNumero() == null || adresse.getNumero() <= 0
				|| adresse.getRue() == null || adresse.getRue().trim().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().trim().isEmpty()
				|| adresse.getCodePostal() == null || adresse.getCodePostal().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}
		adresseDao.update(adresse);
	}

	@Override
	public void remove(Adresse adresse) throws Exception {
		if (adresse == null
				|| adresse.getNumero() == null || adresse.getNumero() <= 0
				|| adresse.getRue() == null || adresse.getRue().trim().isEmpty()
				|| adresse.getVille() == null || adresse.getVille().trim().isEmpty()
				|| adresse.getCodePostal() == null || adresse.getCodePostal().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !");
		}
		adresseDao.remove(adresse);
	}

}
