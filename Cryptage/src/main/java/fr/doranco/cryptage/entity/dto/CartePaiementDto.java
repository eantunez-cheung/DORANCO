package fr.doranco.cryptage.entity.dto;

public class CartePaiementDto {

	private String id;
	private String titulaire;
	private String numero;
	private String dateValidite;
	private String cryptogramme;
	
	public CartePaiementDto() {
	}

	public CartePaiementDto(String titulaire, String numero, String dateValidite, String cryptogramme) {
		this.numero = numero;
		this.dateValidite = dateValidite;
		this.cryptogramme = cryptogramme;
		this.titulaire = titulaire;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(String dateValidite) {
		this.dateValidite = dateValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	@Override
	public String toString() {
		return "CartePaiementDto [id=" + id + ", titulaire=" + titulaire + ", numero=" + numero + ", dateValidite="
				+ dateValidite + ", cryptogramme=" + cryptogramme + "]";
	}
	
}
