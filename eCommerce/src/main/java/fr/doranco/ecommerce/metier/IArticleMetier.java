package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Article;

public interface IArticleMetier {

	void add(Article article) throws Exception;
	Article getArticle(Integer id) throws Exception;
	Article getArticleByNom(String nom) throws Exception;
	Set<Article> getArticles() throws Exception;
	void update(Article article) throws Exception;
	void remove(Integer id) throws Exception;
	
}
