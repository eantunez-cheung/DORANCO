package fr.doranco.cryptage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.cryptage.entity.pojo.CartePaiement;
import fr.doranco.cryptage.model.DataSourceConnexion;
import fr.doranco.cryptage.utils.Dates;

public class CartePaiementDAO implements ICartePaiementDAO {

	Connection conn = null;
	
	@Override
	public Set<CartePaiement> getCartePaiementByUserId(Integer userId) throws Exception {
		
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("L'id doit être supérieur à 0 !");
		}
		Set<CartePaiement> cartesPaiement = new HashSet<CartePaiement>();
		String request = "SELECT * FROM carte_paiement WHERE user_id = ?";
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartePaiement cartePaiement = new CartePaiement();
				cartePaiement.setId(rs.getInt("id"));
				cartePaiement.setTitulaire(rs.getString("titulaire"));
				cartePaiement.setNumero(rs.getBytes("numero"));
				cartePaiement.setDateValidite(Dates.convertDateSqlToDateUtil(rs.getDate("date_validite")));
				cartePaiement.setCryptogramme(rs.getBytes("cryptogramme"));
				cartesPaiement.add(cartePaiement);
			}
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		return cartesPaiement;
	}

	@Override
	public CartePaiement addCartePaiement(CartePaiement cartePaiement, Integer userId) throws Exception {
		if (cartePaiement == null
				|| cartePaiement.getTitulaire() == null || cartePaiement.getTitulaire().trim().isEmpty()
				|| cartePaiement.getNumero() == null
				|| cartePaiement.getDateValidite() == null
				|| cartePaiement.getCryptogramme() == null) {
			
			throw new IllegalArgumentException("Les arguments de la carte de paiement doivent être non nuls !");
		}
		
		if (userId == null || userId <= 0) {
			throw new IllegalArgumentException("L'id doit être supérieur à 0 !");
		}
		String request = "INSERT INTO carte_paiement(titulaire, numero, date_validite, cryptogramme, user_id)"
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cartePaiement.getTitulaire());
			ps.setBytes(2, cartePaiement.getNumero());
			ps.setDate(3, Dates.convertDateUtilToDateSql(cartePaiement.getDateValidite()));
			ps.setBytes(4, cartePaiement.getCryptogramme());
			ps.setInt(5, userId);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				cartePaiement.setId(rs.getInt(1));
			}
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
		return cartePaiement;
	}

}
