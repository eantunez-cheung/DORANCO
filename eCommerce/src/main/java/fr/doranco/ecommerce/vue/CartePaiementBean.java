package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.metier.CartePaiementMetier;
import fr.doranco.ecommerce.metier.ICartePaiementMetier;

@ManagedBean(name = "cartePaiementBean")
@SessionScoped
public class CartePaiementBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "nomProprietaire", value = "")
	private String nomProprietaire;
	
	@ManagedProperty(name = "prenomProprietaire", value = "")
	private String prenomProprietaire;
	
	@ManagedProperty(name = "numero", value = "")
	private String numero;
	
	@ManagedProperty(name = "dateFinValidite", value = "")
	private String dateFinValidite;
	
	@ManagedProperty(name = "cryptogramme", value = "")
	private String cryptogramme;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private String messageError;
	
	ICartePaiementMetier cartePaimentMetier = new CartePaiementMetier();
	
	public CartePaiementBean() {
	}
	
	public String addCarte() {
		CartePaiementDto cartePaiementDto = new CartePaiementDto();
		cartePaiementDto.setNomProprietaire(nomProprietaire);
		cartePaiementDto.setPrenomProprietaire(prenomProprietaire);
		cartePaiementDto.setNumero(numero);
		cartePaiementDto.setDateFinValidite(dateFinValidite);
		cartePaiementDto.setCryptogramme(cryptogramme);
		
		try {
			cartePaimentMetier.add(cartePaiementDto);
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'ajout d'une carte de paiement !";
			System.err.println(e);
			return "";
		}
		
		return "utilisateur";
	}
	
	public String getCarte(Integer id) {
		return "";
	}
	
	public String updateCarte() {
		return "";
	}

	public String removeCarte() {
		return "";
	}

	public String getNomProprietaire() {
		return nomProprietaire;
	}

	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}

	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(String dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
}
