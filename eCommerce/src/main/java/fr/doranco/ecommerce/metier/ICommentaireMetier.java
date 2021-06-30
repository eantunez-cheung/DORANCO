package fr.doranco.ecommerce.metier;

import java.util.Set;

import fr.doranco.ecommerce.entity.pojo.Commentaire;

public interface ICommentaireMetier {

	void add(Commentaire commentaire) throws Exception;
	Set<Commentaire> getCommentaires() throws Exception;
	Set<Commentaire> getCommentairesByNote(Integer note) throws Exception;
	Set<Commentaire> getCommentairesByArticleId(Integer articleId) throws Exception;
}
