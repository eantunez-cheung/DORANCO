package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;
import fr.doranco.ecommerce.utils.Cookies;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(name = "email", value = "")
	private String email;
	
	@ManagedProperty(name = "password", value = "")
	private String password;
	
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;
	
	@ManagedProperty(name = "messageError", value = "")
	private String messageError;
	
	private IUserMetier userMetier = new UserMetier();

	public LoginBean() {
	}

	public String seConnecter() {
		this.messageError = "";
		this.messageSuccess = "";
		UserDto userDto = new UserDto();
		try {
			userDto = userMetier.getUserByEmail(email);
			if (userDto == null) {
				this.messageError = "Email et/ou mot de passe incorrecte !";
				return "";
			}
			if (!userDto.getPassword().equals(password)) {
				this.messageError = "Email et/ou mot de passe incorrecte !";
				return "";
			}
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de la connexion !";
			System.out.println(e);
			return "";
		}
		
		Cookies.setCookie("user", userDto.getId());
		
		return "utilisateur";
	}
	
	public String seDeconnecter() {
		Cookies.removeCookie();
		return "accueil";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
