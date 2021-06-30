package fr.doranco.ecommerce.metier;

import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.beans.Commentaire;
import fr.doranco.ecommerce.model.dao.CommentaireDao;
import fr.doranco.ecommerce.model.dao.ICommentaireDao;

public class CommentaireMetier implements ICommentaireMetier {

	private ICommentaireDao commentaireDao = new CommentaireDao();
	
	@Override
	public void add(Commentaire commentaire) throws Exception {
		if (commentaire ==null
				 || commentaire.getNote() == null || commentaire.getNote() < 0 || commentaire.getNote() > 5
				 || commentaire.getTexte() == null
				 || commentaire.getArticle() == null) {
			throw new IllegalArgumentException("Les paramètres doitvent être non nul et le paramètre 'note' doit être compris entre 0 et 5 !");
		}
		commentaireDao.add(commentaire);
	}

	@Override
	public Set<Commentaire> getCommentaires() throws Exception {
		return new HashSet<Commentaire>(commentaireDao.getAll(Commentaire.class));
	}

	@Override
	public Set<Commentaire> getCommentairesByNote(Integer note) throws Exception {
		if (note == null || note < 0 || note > 5) {
			throw new IllegalArgumentException("Le paramètre 'note' doit être compris entre 0 et 5 !");
		}
		return commentaireDao.getCommentairesByNote(note);
	}

	@Override
	public Set<Commentaire> getCommentairesByArticleId(Integer articleId) throws Exception {
		if (articleId == null || articleId <= 0) {
			throw new IllegalArgumentException("Le paramètre 'articleId' doit être supérieur à 0 !");
		}
		return commentaireDao.getCommentairesByArticleId(articleId);
	}

}
