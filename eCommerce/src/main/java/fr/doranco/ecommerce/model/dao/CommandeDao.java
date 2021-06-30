package fr.doranco.ecommerce.model.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.beans.Commande;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CommandeDao extends AbstractEntityFacade<Commande> implements ICommandeDao {

	private Session session = null;
	
	@Override
	public Commande getCommandesByNumero(String numero) throws Exception {
		if (numero == null || numero.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'numero' doit être non nul et non vide !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findByNumero", Commande.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public Set<Commande> getCommandesByDateCreation(Date dateCreation) throws Exception {
		if (dateCreation == null) {
			throw new IllegalArgumentException("Le paramètre 'dateCreation' doit être non nul !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findByDateCreation", Commande.class);
		query.setParameter("date_creation", dateCreation);
		return new HashSet<Commande>(query.getResultList());
	}

	@Override
	public Set<Commande> getCommandesByUserId(Integer userId) throws Exception {
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("Le paramètre 'userId' doit être supérieur à 0 !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findByUserId", Commande.class);
		query.setParameter("user_id", userId);
		return new HashSet<Commande>(query.getResultList());
	}

}
