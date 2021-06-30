package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.beans.Params;

public class ParamsDao extends AbstractEntityFacade<Params> implements IParamsDao {

	@Override
	public List<Params> getAll(Class<Params> entity) throws Exception {
		return null;
	}

	@Override
	public void update(Params entity) throws Exception {
		throw new IllegalAccessException("Vous n'avez pas le droit d'utiliser cette méthode !");
	}

	@Override
	public void remove(Params entity) throws Exception {
		throw new IllegalAccessException("Vous n'avez pas le droit d'utiliser cette méthode !");
	}
}
