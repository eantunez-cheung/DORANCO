package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.model.dao.ArticleDao;
import fr.doranco.ecommerce.model.dao.IArticleDao;

public class ArticleMetier implements IArticleMetier {

	IArticleDao articleDao = new ArticleDao();
	
	@Override
	public void add(Article article) throws Exception {
		if (article == null
				|| article.getNom() == null || article.getNom().trim().isEmpty()
				|| article.getPrix() == null || article.getPrix() < 0
				|| article.getStock() == null || article.getStock() < 0
				|| article.getRemise() == null || article.getRemise() < 0
				|| article.getDescription() == null || article.getDescription().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !\n"
					+ "Les paramètres 'prix', 'stock', 'remise' doivent être positifs !");
		}
		articleDao.add(article);
	}

	@Override
	public Article getArticle(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être non nul et supérieur à 0 !");
		}
		return articleDao.get(Article.class, id);
	}

	@Override
	public Article getArticleByNom(String nom) throws Exception {
		if (nom == null || nom.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'nom' doit être non nul et non vide !");
		}
		return articleDao.getArticleByNom(nom);
	}

	@Override
	public Set<Article> getArticles() throws Exception {
		return new HashSet<Article>(articleDao.getAll(Article.class));
	}

	@Override
	public void update(Article article) throws Exception {
		if (article == null
				|| article.getNom() == null || article.getNom().trim().isEmpty()
				|| article.getPrix() == null || article.getPrix() < 0
				|| article.getStock() == null || article.getStock() < 0
				|| article.getRemise() == null || article.getRemise() < 0
				|| article.getDescription() == null || article.getDescription().trim().isEmpty()) {
			throw new IllegalArgumentException("Les paramètres doivent être non nuls et non vides !\n"
					+ "Les paramètres 'prix', 'stock', 'remise' doivent être positifs !");
		}
		articleDao.update(article);
	}

	@Override
	public void remove(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être non nul et supérieur à 0 !");
		}
		articleDao.disable(id);
	}

}
