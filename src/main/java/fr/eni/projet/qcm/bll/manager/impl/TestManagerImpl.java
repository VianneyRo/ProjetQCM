package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.TestManager;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.dal.dao.TestDAO;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ValidationUtil;

public class TestManagerImpl implements TestManager{
	
	private static TestManager singleton = null;
	private TestDAO testDAO = DAOFactory.TestDao();
	
	public static TestManager getInstance() {
		if (singleton == null)
			singleton = new TestManagerImpl();
		
		return singleton;
	}
	@Override
	public Test insert(Test test) throws ManagerException {
		Test liste = null;
		
		ValidationUtil.checkNotNull(test);
		
		try {
			liste = testDAO.insert(test);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		return liste;
	}

	@Override
	public List<Test> selectAll() throws ManagerException {
		List<Test> liste = new ArrayList<Test>();
		
		try {
			liste = testDAO.selectAll();
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		return liste;
	}

	@Override
	public void deleteById(int id) throws ManagerException {
		try {
			testDAO.deleteById(id);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		
	}

	@Override
	public Test selectByLibelle(String libelle) throws ManagerException {
		Test liste = null;
		
		ValidationUtil.checkNotNull(libelle);
		
		try {
			liste = testDAO.selectByLibelle(libelle);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		return liste;
		}
	@Override
	public Test selectById(String libelle) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}
	}
