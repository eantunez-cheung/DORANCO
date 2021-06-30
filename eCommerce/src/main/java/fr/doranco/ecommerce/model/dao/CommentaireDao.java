package fr.doranco.ecommerce.model.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.beans.Commentaire;
import fr.doranco.ecommerce.model.HibernateConnector;

public class CommentaireDao extends AbstractEntityFacade<Commentaire> implements ICommentaireDao {

	private Session session = null;
	
	@Override
	public Set<Commentaire> getCommentairesByNote(Integer note) throws Exception {
		if (note == null || note < 0 || note > 5) {
			throw new IllegalArgumentException("Le paramètre 'note' doit être compris entre 0 et 5");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Commentaire> query = session.createNamedQuery("Commentaire.findByNote", Commentaire.class);
		query.setParameter("note", note);
		return new HashSet<Commentaire>(query.getResultList());
	}

	@Override
	public Set<Commentaire> getCommentairesByArticleId(Integer articleId) throws Exception {
		if (articleId == null || articleId <= 0) {
			throw new IllegalArgumentException("Le paramètre 'articleId' doit être supérieur à 0 !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Commentaire> query = session.createNamedQuery("Commentaire.findByArticleId", Commentaire.class);
		query.setParameter("articleId", articleId);
		return new HashSet<Commentaire>(query.getResultList());
	}

}
