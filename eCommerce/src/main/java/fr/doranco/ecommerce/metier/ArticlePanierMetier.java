package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.model.dao.ArticlePanierDao;
import fr.doranco.ecommerce.model.dao.IArticlePanierDao;

public class ArticlePanierMetier implements IArticlePanierMetier {

	IArticlePanierDao articlePanierDao = new ArticlePanierDao();
	
	@Override
	public void add(ArticlePanier articlePanier) throws Exception {
		if (articlePanier == null
				|| articlePanier.getArticle() == null
				|| articlePanier.getQuantite() == null || articlePanier.getQuantite() <= 0) {
			throw new IllegalArgumentException("Les param�tres doivent �tre non null et la quantit�"
					+ " doit �tre sup�rieur � 0");
		}
		articlePanierDao.add(articlePanier);
	}

	@Override
	public Set<ArticlePanier> getArticlesPanier() throws Exception {
		return new HashSet<ArticlePanier>(articlePanierDao.getAll(ArticlePanier.class));
	}

	@Override
	public void update(ArticlePanier articlePanier) throws Exception {
		if (articlePanier == null
				|| articlePanier.getArticle() == null
				|| articlePanier.getQuantite() == null || articlePanier.getQuantite() <= 0) {
			throw new IllegalArgumentException("Les param�tres doivent �tre non null et la quantit�"
					+ " doit �tre sup�rieur � 0");
		}
		articlePanierDao.update(articlePanier);
	}

	@Override
	public void remove(ArticlePanier articlePanier) throws Exception {
		if (articlePanier == null
				|| articlePanier.getArticle() == null
				|| articlePanier.getQuantite() == null || articlePanier.getQuantite() <= 0) {
			throw new IllegalArgumentException("Les param�tres doivent �tre non null et la quantit�"
					+ " doit �tre sup�rieur � 0");
		}
		articlePanierDao.remove(articlePanier);
	}

}
