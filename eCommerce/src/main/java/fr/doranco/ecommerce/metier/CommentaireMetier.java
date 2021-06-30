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
			throw new IllegalArgumentException("Les param�tres doitvent �tre non nul et le param�tre 'note' doit �tre compris entre 0 et 5 !");
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
			throw new IllegalArgumentException("Le param�tre 'note' doit �tre compris entre 0 et 5 !");
		}
		return commentaireDao.getCommentairesByNote(note);
	}

	@Override
	public Set<Commentaire> getCommentairesByArticleId(Integer articleId) throws Exception {
		if (articleId == null || articleId <= 0) {
			throw new IllegalArgumentException("Le param�tre 'articleId' doit �tre sup�rieur � 0 !");
		}
		return commentaireDao.getCommentairesByArticleId(articleId);
	}

}
