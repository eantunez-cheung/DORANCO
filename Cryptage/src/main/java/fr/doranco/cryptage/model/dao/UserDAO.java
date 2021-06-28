package fr.doranco.cryptage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import fr.doranco.cryptage.entity.pojo.CartePaiement;
import fr.doranco.cryptage.entity.pojo.Utilisateur;
import fr.doranco.cryptage.model.DataSourceConnexion;

public class UserDAO implements IUserDAO {

	private Connection conn = null;
	
	@Override
	public Utilisateur getUserByEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("L'email doit être non nul et non vide !");
		}
		Utilisateur utilisateur = new Utilisateur();
		String request = "SELECT * FROM user WHERE email = ?";
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilisateur.setId(rs.getInt("id"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setCleCryptage(rs.getBytes("cle_cryptage"));
				utilisateur.setPassword(rs.getBytes("password"));
			}
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		return utilisateur;
	}

	@Override
	public Utilisateur addUser(Utilisateur user) throws Exception {
		
		if (user == null
				|| user.getNom() == null || user.getNom().trim().isEmpty()
				|| user.getPrenom() == null || user.getPrenom().trim().isEmpty()
				|| user.getEmail() == null || user.getEmail().trim().isEmpty()
				|| user.getPassword() == null
				|| user.getCleCryptage() == null) {
					
			throw new IllegalArgumentException("Les argument de l'utilisateur doivent être non nuls et non vides !");
		}
				
		String request = "INSERT INTO user(nom, prenom, email, password, cle_cryptage)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setBytes(4, user.getPassword());
			ps.setBytes(5, user.getCleCryptage());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getInt(1));
			}
			if (user.getCartePaiements() != null && !user.getCartePaiements().isEmpty()) {
				ICartePaiementDAO paiementDAO = new CartePaiementDAO();
				for (CartePaiement cartePaiement : user.getCartePaiements()) {
					paiementDAO.addCartePaiement(cartePaiement, user.getId());
				}
			}
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		return user;
	}

	@Override
	public Utilisateur getCleCryptage(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'email doit être non nul et non vide !");
		}
		Utilisateur utilisateur = new Utilisateur();
		String request = "SELECT cle_cryptage FROM user WHERE id = ?";
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				utilisateur.setCleCryptage(rs.getBytes("cle_cryptage"));
			}
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		return utilisateur;
	}

}
