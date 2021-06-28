package fr.doranco.users.model.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import fr.doranco.users.entity.User;
import fr.doranco.users.model.HibernateConnector;

public class UserDao extends AbstractEntityFacade<User> implements IUserDao {

	//Avec Query
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

	//Avec NativQuery
	@Override
	public List<User> getUsersOfVille(String ville) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT * FROM utilisateur u INNER JOIN adresse a ON u.id = a.user_id WHERE a.ville = :ville";
		NativeQuery<User> query = session.createNativeQuery(request, User.class);
		query.setParameter("ville", ville);
		return query.getResultList();
	}

	//Avec NamedQuery
	@Override
	public User getUserByEmail(String email) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createNamedQuery("User.findByEmail");
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		return user;
	}

	
}
