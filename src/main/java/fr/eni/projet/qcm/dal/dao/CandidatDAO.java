package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface CandidatDAO extends GenericDAO<Candidat, Integer> {
	boolean checkExistenceWithName(String name) throws DaoException;
}
