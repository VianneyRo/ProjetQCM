package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface TestDAO {
	
	Test insert(Test test) throws DaoException;
	
	List<Test> selectAll() throws DaoException;

	Test selectByLibelle(String libelle) throws DaoException;

	void deleteById(Integer id) throws DaoException;

	void update(Test test) throws DaoException;
}
