package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.model.HibernateConnector;

public class ArticleDao extends AbstractEntityFacade<Article> implements IArticleDao {

	Session session = null;

	@Override
	public Article getArticleByNom(String nom) throws Exception {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'nom' doit être non nul et non vide !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<Article> query = session.createNamedQuery("Article.findByNom", Article.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}

	@Override
	public void disable(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("UPDATE Article a Set is_vendable = false WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
