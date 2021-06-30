package fr.doranco.ecommerce.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Commentaire;

public interface ICommentaireDao extends IEntityFacade<Commentaire>{

	Set<Commentaire> getCommentairesByNote(Integer note) throws Exception;
	Set<Commentaire> getCommentairesByArticleId(Integer articleId) throws Exception;
}
