package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.beans.Article;

public interface IArticleDao extends IEntityFacade<Article> {

	Article getArticleByNom(String nom) throws Exception;
	void disable(Integer id) throws Exception;
}
