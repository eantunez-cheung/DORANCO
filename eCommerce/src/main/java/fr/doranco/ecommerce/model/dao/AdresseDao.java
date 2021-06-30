package fr.doranco.ecommerce.model.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.model.HibernateConnector;

public class AdresseDao extends AbstractEntityFacade<Adresse> implements IAdresseDao {

	Session session = null;
	
	@Override
	public Set<Adresse> getAdressesByUserId(Integer userId) throws Exception {
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("Le paramètre 'userId' doit être supérieur à 0 !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Adresse> query = session.createNamedQuery("Adresse.findByUserId", Adresse.class);
		query.setParameter("userId", userId);
		return new HashSet<Adresse>(query.getResultList());
	}

	@Override
	public Set<Adresse> getAdressesByVille(String ville) throws Exception {
		if (ville == null || ville.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'ville' doit être non nul et non vide !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Adresse> query = session.createNamedQuery("Adresse.findByVille", Adresse.class);
		query.setParameter("ville", ville);
		return new HashSet<Adresse>(query.getResultList());
	}

}
