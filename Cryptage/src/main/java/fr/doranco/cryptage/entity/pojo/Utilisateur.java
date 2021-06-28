package fr.doranco.cryptage.entity.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.algo.CryptageDesPbeBlowfish;
import fr.doranco.cryptage.enums.AlgorithmesCryptagePrincipal;

public class Utilisateur {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private byte[] password;
	private byte[] cleCryptage;
	private Set<CartePaiement> cartePaiements;
	
	public Utilisateur() {
		this.cartePaiements = new HashSet<CartePaiement>();
	}
	
	public Utilisateur(String nom, String prenom, String email, byte[] password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.cartePaiements = new HashSet<CartePaiement>();
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
	
	public byte[] getCleCryptage() {
		return cleCryptage;
	}

	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	public Set<CartePaiement> getCartePaiements() {
		return cartePaiements;
	}

	@Override
	public String toString() {
		String passwordDecrypte = null;
		try {
			passwordDecrypte = CryptageDesPbeBlowfish.decrypt(AlgorithmesCryptagePrincipal.DES.getAlgorithme(),
																password,
																new SecretKeySpec(cleCryptage, AlgorithmesCryptagePrincipal.DES.getAlgorithme()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ passwordDecrypte + "]";
	}

}
