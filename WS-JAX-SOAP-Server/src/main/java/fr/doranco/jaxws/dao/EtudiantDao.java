package fr.doranco.jaxws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class EtudiantDao implements IEtudiantDao {

	Connection conn = null;
	
	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "SELECT * FROM etudiant";
			PreparedStatement ps = conn.prepareStatement(request);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etudiant etudiant = new Etudiant(rs.getString("nom"), rs.getString("prenom"),
						rs.getString("specialite"), rs.getInt("age"));
				etudiant.setId(rs.getInt("id"));
				etudiants.add(etudiant);
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return etudiants;
	}

	@Override
	public Etudiant getEtudiantbyId(Integer id) throws Exception {
		Etudiant etudiant = null;
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "SELECT * FROM etudiant WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(request);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				etudiant = new Etudiant(rs.getString("nom"), rs.getString("prenom"),
						rs.getString("specialite"), rs.getInt("age"));
				etudiant.setId(rs.getInt("id"));
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return etudiant;
	}

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		try {
			conn = DataSourceConnexion.getInstance().getConnection();
			String request = "INSERT INTO etudiant(nom, prenom, specialite, age) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getSpecialite());
			if (etudiant.getAge() != null) {
				ps.setInt(4, etudiant.getAge());
			} else {
				ps.setNull(4, Types.INTEGER);
			}
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				etudiant.setId(rs.getInt(1));
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return etudiant;
	}
}
