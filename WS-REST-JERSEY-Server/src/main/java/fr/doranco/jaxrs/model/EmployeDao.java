package fr.doranco.jaxrs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.doranco.jaxrs.connexion.DataSourceConnexion;
import fr.doranco.jaxrs.jersey.entity.Employe;

public class EmployeDao implements IEmployeDao {

	Connection conn = null;
	
	@Override
	public Employe addEmploye(Employe employe) throws Exception {
		if (employe == null
				|| employe.getNom() == null || employe.getNom().isEmpty()
				|| employe.getPrenom() == null || employe.getPrenom().isEmpty()
				|| employe.getPosteOccupe() == null || employe.getPosteOccupe().isEmpty()) {
			throw new IllegalArgumentException("Les paramètre 'nom', 'prenom' et 'posteOccupe' doivent être non nuls et non vides");
		}
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "INSERT INTO employe(nom, prenom, poste_occupe) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, employe.getNom());
			ps.setString(2, employe.getPrenom());
			ps.setString(3, employe.getPosteOccupe());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				employe.setId(rs.getInt(1));
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return employe;
	}

	@Override
	public List<Employe> getEmployes() throws Exception {
		List<Employe> employes = new ArrayList<Employe>();
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "SELECT * FROM employe";
			PreparedStatement ps = conn.prepareStatement(request);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employe employe = new Employe(rs.getString("nom"), rs.getString("prenom"), rs.getString("poste_occupe"));
				employe.setId(rs.getInt("id"));
				employes.add(employe);
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return employes;
	}

	@Override
	public Employe getEmployeById(Integer id) throws Exception {
		Employe employe = null;
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id doit être positif et non nul");
		}
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "SELECT * FROM employe WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employe = new Employe(rs.getString("nom"), rs.getString("prenom"), rs.getString("poste_occupe"));
				employe.setId(rs.getInt("id"));
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return employe;
	}

	@Override
	public void updateEmploye(Employe employe) throws Exception {
		if (employe == null
				|| employe.getNom() == null || employe.getNom().isEmpty()
				|| employe.getPrenom() == null || employe.getPrenom().isEmpty()
				|| employe.getPosteOccupe() == null || employe.getPosteOccupe().isEmpty()) {
			throw new IllegalArgumentException("Les paramètre 'nom', 'prenom' et 'posteOccupe' doivent être non nuls et non vides");
		}
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "UPDATE employe SET nom = ?, prenom = ?, poste_occupe = ? WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setString(1, employe.getNom());
			ps.setString(2, employe.getPrenom());
			ps.setString(3, employe.getPosteOccupe());
			ps.setInt(4, employe.getId());
			ps.executeUpdate();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	@Override
	public void removeEmploye(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("L'id doit être positif et non nul");
		}
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "DELETE FROM employe WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
