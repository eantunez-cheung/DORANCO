package fr.doranco.cryptage.entity.pojo;

import java.util.Date;

public class CartePaiement {

	private Integer id;
	private String titulaire;
	private byte[] numero;
	private Date dateValidite;
	private byte[] cryptogramme;
	
	public CartePaiement() {
	}

	public CartePaiement(byte[] numero, Date dateValidite) {
		this.numero = numero;
		this.dateValidite = dateValidite;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}

	public byte[] getNumero() {
		return numero;
	}

	public void setNumero(byte[] numero) {
		this.numero = numero;
	}

	public Date getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(Date dateValidite) {
		this.dateValidite = dateValidite;
	}

	public byte[] getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(byte[] cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", titulaire=" + titulaire + ", numero=" + numero
				+ ", dateValidite=" + dateValidite + ", cryptogramme=" + cryptogramme + "]";
	}

}
