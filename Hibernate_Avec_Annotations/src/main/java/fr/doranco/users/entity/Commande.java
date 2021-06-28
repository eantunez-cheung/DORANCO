package fr.doranco.users.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "commande", catalog = "hibernate_db_anot")
@NamedQueries({
	@NamedQuery(name = "Commande.findAll", query = "FROM Commande c"),
	@NamedQuery(name = "Commande.findById", query = "FROM Commande c WHERE id = :id"),
	@NamedQuery(name = "Commande.findByUserId", query = "FROM Commande c WHERE c.user.id = :id"),
//	@NamedQuery(name = "Commande.findByVille", query = "FROM Commande c WHERE c.user.adresses.ville = :ville")
})
public class Commande implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotEmpty
	@Column(name = "numero", nullable = false)
	private String numero;
	
	@NotNull
	@Column(name = "date_commande", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@NotEmpty
	@Column(name = "date_livraison", nullable = false)
	private String dateLivraison;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<LigneDeCommande> lignesDeCommandes;

	public Commande() {
		lignesDeCommandes = new HashSet<LigneDeCommande>();
	}

	public Commande(String numero, Date dateCommande, String dateLivraison) {
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
		lignesDeCommandes = new HashSet<LigneDeCommande>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<LigneDeCommande> getLignesDeCommandes() {
		return lignesDeCommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + "]";
	}
	
	
}
