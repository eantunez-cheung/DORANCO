package fr.doranco.ecommerce.model.dao;

import fr.doranco.ecommerce.entity.pojo.Params;

public interface IParamsDao extends IEntityFacade<Params> {

	byte[] getCleCryptage(Integer id) throws Exception;
}
