package fr.doranco.ecommerce.vue;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.enums.TypeUtilisateur;
import fr.doranco.ecommerce.metier.IUserMetier;
import fr.doranco.ecommerce.metier.UserMetier;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	@ManagedProperty(name = "nom", value = "")
	private String nom;

	@ManagedProperty(name = "prenom", value = "")
	private String prenom;

	@ManagedProperty(name = "dateNaissance", value = "")
	private String dateNaissance;

	@ManagedProperty(name = "profil", value = "")
	private String profil;

	@ManagedProperty(name = "email", value = "")
	private String email;

	@ManagedProperty(name = "password", value = "")
	private String password;

	@ManagedProperty(name = "confirmPassword", value = "")
	private String confirmPassword;

	@ManagedProperty(name = "telephone", value = "")
	private String telephone;

	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess;

	@ManagedProperty(name = "messageError", value = "")
	private String messageError;

	private IUserMetier userMetier = new UserMetier();

	public UserBean() {
	}

	public String addUser() {
		UserDto userDto = null;
		if (!password.equals(confirmPassword)) {
			this.messageError = "Le mot de passe et la confirmation du mot de passe sont différent !";
			return "";
		}
		
		
		
		try {
			userDto = userMetier.getUserByEmail(email);
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'ajout de l'utilisateur Email!";
			System.out.println(e);
			return "";
		}
		
		if (userDto != null) {
			this.messageError = "L'email est déjà utilisé !";
			return "";
		}
		
		userDto = new UserDto();
		userDto.setNom(nom);
		userDto.setPrenom(prenom);
		userDto.setDateNaissance(dateNaissance);
		userDto.setProfil(TypeUtilisateur.CLIENT.getTypeUtilisateur());
		userDto.setEmail(email);
		userDto.setPassword(confirmPassword);
		userDto.setTelephone(telephone);

		try {
			userMetier.add(userDto);
		} catch (Exception e) {
			this.messageError = "Erreur technique lors de l'ajout de l'utilisateur !";
			System.out.println(e);
		}
		return "login";
	}

	public String updateUser() {
		return "";
	}

	public String removeUser(String id) {
		return "";
	}

	public String showUser(UserDto userDto) {
		this.nom = userDto.getNom();
		this.prenom = userDto.getPrenom();
		this.dateNaissance = userDto.getDateNaissance();
		this.email = userDto.getEmail();
		this.telephone = userDto.getTelephone();
		return "";
	}

	public Set<UserDto> getUsers() {
		Set<UserDto> usersDto = new HashSet<UserDto>();
		try {
			usersDto = userMetier.getUsers();
		} catch (Exception e) {
			messageError = "Erreur technique | Veuillez réessayer plus tard.\n" + e.getMessage();
		}
		return usersDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
