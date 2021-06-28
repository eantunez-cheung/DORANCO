package fr.doranco.jaxrs.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DataSourceConnexion {

	private static DataSourceConnexion instance;
	private Connection conn;
	
	private DataSourceConnexion() throws Exception {
	}

	public Connection getConnection() throws Exception {
		if (conn == null || (conn != null && conn.isClosed())) {
			ResourceBundle rb = ResourceBundle.getBundle("fr.doranco.model.dbfile");
			String user = rb.getString("user");
			String password = rb.getString("password");
			// On peut mettre 'localhost' � la place de '127.0.0.1'
			String url = rb.getString("url");
			
//			On met ce code au cas ou il m'affiche une erreur de type de Driver qui n'a pas �t� trouv�.
			Class.forName(rb.getString("driver"));
			conn = DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
	
	public static synchronized DataSourceConnexion getInstance() throws Exception {
		if (instance == null) {
			instance = new DataSourceConnexion();
		}
		return instance;
	}
}
