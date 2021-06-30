package fr.doranco.ecommerce.entity.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "article", catalog = "projet_ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "Article.findByNom", query = "FROM Article a WHERE nom = :nom")
})
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "description", nullable = false)
	private String description;
	
	@NotNull
	@Column(name = "prix", nullable = false)
	private Float prix;
	
	@NotNull
	@Column(name = "remise", length = 3, nullable = false)
	private Integer remise;
	
	@NotNull
	@Column(name = "stock", length = 5, nullable = false)
	private Integer stock;
	
	@NotNull
	@Column(name = "is_vendable", nullable = false)
	private boolean isVendable;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie; 
	
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commentaire> commentaires;
	
	public Article() {
		this.commentaires = new HashSet<Commentaire>();
		this.isVendable = true;
	}

	public Article(String nom, String description, Float prix, Integer remise, Integer stock) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.commentaires = new HashSet<Commentaire>();
		this.isVendable = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Integer getRemise() {
		return remise;
	}

	public void setRemise(Integer remise) {
		this.remise = remise;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isVendable() {
		return isVendable;
	}

	public void setVendable(boolean isVendable) {
		this.isVendable = isVendable;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", remise="
				+ remise + ", stock=" + stock + ", isVendable=" + isVendable + "]";
	}
}
