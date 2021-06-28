package fr.doranco.users.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.users.entity.Personne;
import fr.doranco.users.model.HibernateUtil;

public class PersonneDao implements IPersonneDao {

	private Session session = null;
	private Transaction transaction = null;
	
	@Override
	public void addPersonne(Personne personne) throws Exception {
		try {
			session = HibernateUtil.getInstance().getSession();
			transaction = session.beginTransaction();
			session.save(personne);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Personne getPersonne(Integer id) throws Exception {
		Personne personne = null;
		try {
			session = HibernateUtil.getInstance().getSession();
			personne = (Personne) session.get(Personne.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return personne;
	}

	@Override
	public void updatePersonne(Personne personne) throws Exception {
		try {
			session = HibernateUtil.getInstance().getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(personne);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void removePersonne(Personne personne) throws Exception {
		try {
			session = HibernateUtil.getInstance().getSession();
			transaction = session.beginTransaction();
			session.delete(personne);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
