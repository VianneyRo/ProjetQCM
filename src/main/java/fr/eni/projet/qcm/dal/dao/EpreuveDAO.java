package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface EpreuveDAO extends GenericDAO<Epreuve, Integer> {
	boolean checkExistenceWithName(String name) throws DaoException;
}
