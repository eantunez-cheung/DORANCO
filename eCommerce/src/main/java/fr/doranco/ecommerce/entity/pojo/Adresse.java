package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adresse", catalog = "projet_ecommerce_db")
@NamedQueries({
	@NamedQuery(name = "Adresse.findByUserId", query = "FROM Adresse a WHERE user_id = :userId"),
	@NamedQuery(name = "Adresse.findByVille", query = "FROM Adresse a WHERE ville = :ville")
})
public class Adresse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "numero", length = 4, nullable = false)
	private Integer numero;
	
	@NotEmpty
	@Column(name = "rue", length = 40, nullable = false)
	private String rue;
	
	@NotEmpty
	@Column(name = "ville", length = 25, nullable = false)
	private String ville;
	
	@NotEmpty
	@Column(name = "code_postal", length = 5, nullable = false)
	private String codePostal;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	public Adresse() {
	}

	public Adresse(Integer numero, String rue, String ville, String codePostal) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}
}
