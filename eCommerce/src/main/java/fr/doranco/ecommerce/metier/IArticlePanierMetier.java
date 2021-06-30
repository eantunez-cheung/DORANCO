package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.ArticlePanier;

public interface IArticlePanierMetier {

	void add(ArticlePanier articlePanier) throws Exception;
	Set<ArticlePanier> getArticlesPanier() throws Exception;
	void update(ArticlePanier articlePanier) throws Exception;
	void remove(ArticlePanier articlePanier) throws Exception;
}
