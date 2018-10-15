package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface TestDAO {

	public List<Test> selectAll() throws DaoException;
	public Test selectById(Integer id) throws DaoException;

	public Test insert(Test test) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Test test) throws DaoException;

}
