package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.model.HibernateConnector;

public class ParamsDao extends AbstractEntityFacade<Params> implements IParamsDao {

	@Override
	public byte[] getCleCryptage(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Le paramètre 'id' doit être supérieur à 0 !");
		}
		Session session = HibernateConnector.getInstance().getSession();
		Query<?> query = session.createNamedQuery("Params.findById");
		query.setParameter("id", id);
		return (byte[]) query.getSingleResult();
	}

}
