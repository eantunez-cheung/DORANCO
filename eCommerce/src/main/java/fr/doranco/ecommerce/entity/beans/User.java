package fr.doranco.ecommerce.entity.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user", catalog = "projet_ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "User.findByEmail", query = "FROM User u WHERE email = :email")
})
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@NotEmpty
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	
	@NotNull
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@NotNull
	@Column(name = "is_actif", nullable = false)
	private boolean isActif;
	
	@NotEmpty
	@Column(name = "profil", length = 4, nullable = false)
	private String profil;
	
	@NotEmpty
	@Column(name = "email", length = 45, unique = true, nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "password", nullable = false)
	private byte[] password;
	
	@Column(name = "telephone", length = 15)
	private String telephone;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Adresse> adresses;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commande> commandes;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CartePaiement> cartesPaiement;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Commentaire> commentaires;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ArticlePanier> panier;
	
	public User() {
		this.adresses = new HashSet<Adresse>();
		this.commandes = new HashSet<Commande>();
		this.commentaires = new HashSet<Commentaire>();
		this.cartesPaiement = new HashSet<CartePaiement>();
		this.panier = new ArrayList<ArticlePanier>();
		this.isActif = true;
	}

	public User(String nom, String prenom, Date dateNaissance, String profil, String email, byte[] password) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.email = email;
		this.password = password;
		this.adresses = new HashSet<Adresse>();
		this.commandes = new HashSet<Commande>();
		this.commentaires = new HashSet<Commentaire>();
		this.cartesPaiement = new HashSet<CartePaiement>();
		this.panier = new ArrayList<ArticlePanier>();
		this.isActif = true;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public Set<CartePaiement> getCartesPaiement() {
		return cartesPaiement;
	}

	public Set<Commentaire> getCommentaires() {
		return commentaires;
	}

	public List<ArticlePanier> getPanier() {
		return panier;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", isActif=" + isActif + ", profil=" + profil + ", email=" + email + ", telephone=" + telephone + "]";
	}
}
