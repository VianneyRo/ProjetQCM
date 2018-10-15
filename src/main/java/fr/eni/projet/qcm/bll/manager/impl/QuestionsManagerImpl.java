package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.QuestionsManager;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;


public class QuestionsManagerImpl implements QuestionsManager {

    private QuestionDAO questionDAO = DAOFactory.questionDao();
    
    private static QuestionsManagerImpl instance;

    private QuestionsManagerImpl() {}

    public static QuestionsManagerImpl getInstance() {
    	if(instance == null) {
    		instance = new QuestionsManagerImpl();
    	}
    	return instance;
    }

	@Override
	public Question insert(Question question) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectAll() throws ManagerException {
		List<Question> liste = new ArrayList<Question>();
		
		try {
			liste = questionDAO.selectAll();
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		return liste;
	}

	@Override
	public void deleteById(int id) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question selectByEnonce(String enonce) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	

}