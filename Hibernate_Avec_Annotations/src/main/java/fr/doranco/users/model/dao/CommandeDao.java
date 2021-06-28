package fr.doranco.users.model.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import fr.doranco.users.entity.Commande;
import fr.doranco.users.model.HibernateConnector;

public class CommandeDao extends AbstractEntityFacade<Commande> implements ICommandeDao {

	// createNativeQuery
	@Override
	public List<Commande> getListeCommandes1() throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT * FROM commande";
		NativeQuery<Commande> query = session.createNativeQuery(request, Commande.class);
		return query.getResultList();
	}

	// createQuery
	@Override
	public List<Commande> getListeCommandes2() throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT c FROM Commande c";
		Query<Commande> query = session.createQuery(request, Commande.class);
		return query.getResultList();
	}

	// createNamedQuery
	@Override
	public List<Commande> getListeCommandes3() throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findAll", Commande.class);
		return query.getResultList();
	}

	// createNamedQuery
	@Override
	public List<Commande> getListeCommandesById(Integer id) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findById", Commande.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	// createNamedQuery
	@Override
	public List<Commande> getListeCommandesByUtilisateurId(Integer utilisateurId) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		Query<Commande> query = session.createNamedQuery("Commande.findByUserId", Commande.class);
		query.setParameter("id", utilisateurId);
		return query.getResultList();
	}

	// createNamedQuery
	@Override
	public List<Commande> getListeCommandesByNom(String nom) throws Exception {

		return null;
	}

	// createQuery
	@Override
	public List<Commande> getListeCommandesByVille(String ville) throws Exception {

		return null;
	}

	@Override
	public Map<String, Integer> getNbCommandesByVille(String orderBy) throws Exception {
		Map<String, Integer> orderByVille = new HashMap<String, Integer>();
		LinkedHashMap<String, Integer> orderByCommande = new LinkedHashMap<String, Integer>();
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT DISTINCT a.ville FROM Adresse a ORDER BY a.ville ASC";
		TypedQuery<String> query = session.createQuery(request, String.class);
		List<String> villes = query.getResultList();
		for (String ville : villes) {
			orderByVille.put(ville, getNbCommandesOfVille(ville));
		}
		if (orderBy.equals("commande")) {
			orderByVille.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(x -> orderByCommande.put(x.getKey(), x.getValue()));
			return orderByCommande;
		}
		return orderByVille;
	}

	@Override
	public Integer getNbCommandesOfVille(String ville) throws Exception {
		Session session = HibernateConnector.getInstance().getSession();
		String request = "SELECT count(*) FROM commande INNER JOIN utilisateur ON commande.user_id = utilisateur.id INNER JOIN (SELECT * FROM adresse) a ON a.user_id = utilisateur.id WHERE ville = :ville";
		Query<?> query = session.createNativeQuery(request);
		query.setParameter("ville", ville);
		return Integer.parseInt(query.getSingleResult().toString());
	}

}
