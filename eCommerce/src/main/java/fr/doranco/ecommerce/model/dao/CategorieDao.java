package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.beans.Categorie;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CategorieDao extends AbstractEntityFacade<Categorie> implements ICategorieDao {

	@Override
	public Categorie getCategorieByNom(String nom) throws Exception {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'nom' doit être non nul et non vide !");
		}
		Session session = HibernateConnector.getInstance().getSession();
		Query<Categorie> query = session.createNamedQuery("Categorie.findByNom", Categorie.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}

}
