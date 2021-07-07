package fr.doranco.ecommerce.vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Cookie;

import fr.doranco.ecommerce.entity.beans.ArticlePanier;
import fr.doranco.ecommerce.entity.beans.User;
import fr.doranco.ecommerce.utils.Cookies;

@ManagedBean(name = "articlePanierBean")
@SessionScoped
public class ArticlePanierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "quantite", value = "")
	private String quantite;

	private final Cookie cookie = Cookies.getCookie("user");
	
	public ArticlePanierBean() {
	}
	
	public void addArticlePanier() {
		User user = new User();
		user.setId(Integer.valueOf(cookie.getValue()));
		ArticlePanier articlePanier = new ArticlePanier(1);
		articlePanier.setUser(user);
		
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
}
