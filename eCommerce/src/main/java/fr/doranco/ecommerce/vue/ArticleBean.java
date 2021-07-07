package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.beans.Article;
import fr.doranco.ecommerce.metier.ArticleMetier;
import fr.doranco.ecommerce.metier.IArticleMetier;

@ManagedBean(name = "articleBean")
@SessionScoped
public class ArticleBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "nom", value = "")
	private String nom;
	
	@ManagedProperty(name = "description", value = "")
	private String description;
	
	@ManagedProperty(name = "prix", value = "")
	private String prix;
	
	@ManagedProperty(name = "remise", value = "")
	private String remise;
	
	@ManagedProperty(name = "stock", value = "")
	private String stock;
	
	@ManagedProperty(name = "messageSucces", value = "")
	private String messageSucces;
	
	@ManagedProperty(name = "messageErreur", value = "")
	private String messageErreur;
	
	IArticleMetier articleMetier = new ArticleMetier();
	
	public ArticleBean() {
	}
	
	public String addArticle() {
		Article article = new Article();
		article.setNom(nom);
		article.setDescription(description);
		article.setPrix(Float.valueOf(prix));
		article.setRemise(Integer.valueOf(remise));
		article.setStock(Integer.valueOf(stock));
		
		try {
			articleMetier.add(article);
			return "utilisateur";
		} catch (Exception e) {
			this.messageErreur = "Erreur technique lors de l'ajout d'un article !";
			System.err.println(e);
			return "";
		}
	}
	
	public Article getArticle() {
		return null;
	}
	
	public Set<Article> getArticles() {
		try {
			Set<Article> articles = articleMetier.getArticles();
			return articles;
		} catch (Exception e) {
			this.messageErreur = "Erreur technique lors de la récupération de tous les articles !";
			System.err.println(e);
			return null;
		}
	}
	
	public String updateArticle() {
		return "";
	}
	
	public String removeArticle() {
		return "";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getRemise() {
		return remise;
	}

	public void setRemise(String remise) {
		this.remise = remise;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getMessageSucces() {
		return messageSucces;
	}

	public void setMessageSucces(String messageSucces) {
		this.messageSucces = messageSucces;
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}
}
