package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.Article;

public interface IArticleDao extends IEntityFacade<Article> {

	Article getArticleByNom(String nom) throws Exception;
}
