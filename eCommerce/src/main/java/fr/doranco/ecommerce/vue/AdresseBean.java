package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.doranco.ecommerce.entity.beans.Adresse;
import fr.doranco.ecommerce.metier.AdresseMetier;
import fr.doranco.ecommerce.metier.IAdresseMetier;

@ManagedBean(name =  "adresseBean")
@SessionScoped
public class AdresseBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "numero", value = "")
	private String numero;
	
	@ManagedProperty(name = "rue", value = "")
	private String rue;
	
	@ManagedProperty(name = "ville", value = "")
	private String ville;
	
	@ManagedProperty(name = "codePostal", value = "")
	private String codePostal;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private String messageError;
	

	private IAdresseMetier adresseMetier = new AdresseMetier();
	
	public AdresseBean() {
	}
	
	public String addAdresse() {
		Adresse adresse = new Adresse();
		adresse.setNumero(Integer.valueOf(numero));
		adresse.setRue(rue);
		adresse.setVille(ville);
		adresse.setCodePostal(codePostal);
		
		String context = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		
		System.out.println("Context Name : " + context);
		return "";
	}
	
	public String updateAdresse() {
		return "";
	}
	
	public String removeAdresse() {
		return "";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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
