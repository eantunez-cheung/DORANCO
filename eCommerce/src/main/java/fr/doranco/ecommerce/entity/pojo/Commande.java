package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commande", catalog = "projet_ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "Commande.findByUserId", query = "FROM Commande c WHERE user_id = :userId"),
	@NamedQuery(name = "Commande.findByDateCreation", query = "FROM Commande c WHERE date_creation = :dateCreation"),
	@NamedQuery(name = "Commande.findByNumero", query = "FROM Commande c WHERE numero = :numero"),
	
})
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@GeneratedValue
	@Column(name = "numero", unique = true, length = 8, nullable = false)
	private UUID numero;
	
	@NotNull
	@Column(name = "date_creation", nullable = false)
	private Date dateCreation;
	
	@NotNull
	@Column(name = "date_livraison", nullable = false)
	private Date dateLivraison;
	
	@NotNull
	@Column(name = "total_remise", nullable = false)
	private Float totalRemise;
	
	@NotNull
	@Column(name = "frais_expedition", nullable = false)
	private Float fraisExpedition;
	
	@NotNull
	@Column(name = "total_general", nullable = false)
	private Float totalGeneral;
	
	@OneToOne
	@JoinColumn(name = "adresse_facturation", nullable = false)
	private Adresse adresseFacturation;
	
	@OneToOne
	@JoinColumn(name = "adresse_livraison", nullable = false)
	private Adresse adresseLivraison;
	
	@OneToOne
	@JoinColumn(name = "carte_paiement_default", nullable = false)
	private CartePaiement cartePaiementDefault;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LigneDeCommande> lignesCommande;
	
	public Commande() {
		this.lignesCommande = new HashSet<LigneDeCommande>();
	}

	public Commande( Date dateLivraison, Float totalRemise, Float fraisExpedition,
			Float totalGeneral) {
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.lignesCommande = new HashSet<LigneDeCommande>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getNumero() {
		return numero;
	}

	public void setNumero(UUID numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Float getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(Float totalRemise) {
		this.totalRemise = totalRemise;
	}

	public Float getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(Float fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public Float getTotalGeneral() {
		return totalGeneral;
	}

	public void setTotalGeneral(Float totalGeneral) {
		this.totalGeneral = totalGeneral;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public CartePaiement getCartePaiementDefault() {
		return cartePaiementDefault;
	}

	public void setCartePaiementDefault(CartePaiement cartePaiementDefault) {
		this.cartePaiementDefault = cartePaiementDefault;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<LigneDeCommande> getLignesCommande() {
		return lignesCommande;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCreation=" + dateCreation + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", totalGeneral=" + totalGeneral + ", user=" + user + "]";
	}
}
