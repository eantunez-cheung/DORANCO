package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.pojo.Article;

public interface IArticleDao extends IEntityFacade<Article> {

	Article getArticleByNom(String nom) throws Exception;
	void disable(Integer id) throws Exception;
}
