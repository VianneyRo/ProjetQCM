package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface CollaborateurDAO extends GenericDAO<Collaborateur, Integer> {
	boolean checkExistenceWithName(String name) throws DaoException;
}
