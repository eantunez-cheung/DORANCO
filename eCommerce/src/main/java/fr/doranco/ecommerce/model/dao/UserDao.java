package fr.doranco.ecommerce.model.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.beans.User;
import fr.doranco.ecommerce.model.HibernateConnector;

public class UserDao extends AbstractEntityFacade<User> implements IUserDao {

	private Session session = null;

	@Override
	public User getUserByEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'email' doit être non nul et non vide !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<User> query = session.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Map<String, Set<User>> getUsersByVille() throws Exception {
		Map<String, Set<User>> usersByVille = new HashMap<String, Set<User>>();
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT DISTINCT a.ville FROM Adresse a";
		TypedQuery<String> query = session.createQuery(request, String.class);
		List<String> villes = query.getResultList();
		for (String ville : villes) {
			usersByVille.put(ville, new HashSet<User>(getUsersOfVille(ville)));
		}
		return usersByVille;
	}

	@Override
	public List<User> getUsersOfVille(String ville) throws Exception {
		if (ville == null || ville.trim().isEmpty()) {
			throw new IllegalArgumentException("Le paramètre 'ville' doit être non nul et non vide !");
		}
		session = HibernateConnector.getInstance().getSession();
		String request = "SELECT * FROM utilisateur u INNER JOIN adresse a ON u.id = a.user_id WHERE a.ville = :ville";
		NativeQuery<User> query = session.createNativeQuery(request, User.class);
		query.setParameter("ville", ville);
		return query.getResultList();
	}

	@Override
	public void disable(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createQuery("UPDATE User a Set is_actif = false WHERE id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
