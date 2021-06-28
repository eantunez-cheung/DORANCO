package fr.doranco.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ligne_de_commande", catalog = "projet_ecommerce_db")
public class LigneDeCommande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "quantite", length = 3, nullable = false)
	private Integer quantite;
	
	@NotNull
	@Column(name = "prix_unitaire", nullable = false)
	private Float prixUnitaire;
	
	@NotNull
	@Column(name = "remise_article", nullable = false)
	private Float remiseArticle;
	
	@ManyToOne
	@JoinColumn(name = "commande_id", nullable = false)
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Article article;
	
	public LigneDeCommande() {
	}

	public LigneDeCommande(Integer quantite, Float prixUnitaire, Float remiseArticle) {
		super();
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Float getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(Float remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneDeCommande [id=" + id + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire
				+ ", remiseArticle=" + remiseArticle + "]";
	}
}
