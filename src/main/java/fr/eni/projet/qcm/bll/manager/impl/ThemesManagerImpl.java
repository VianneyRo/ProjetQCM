package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.PropositionDAO;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.dao.ThemeDAO;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public class ThemesManagerImpl implements ThemesManager {
    private ThemeDAO themeDAO = DAOFactory.themeDao();
    private QuestionDAO questionDAO = DAOFactory.questionDao();
    private PropositionDAO propositionDAO = DAOFactory.propositionDAO();
    private static ThemesManagerImpl instance;

    private ThemesManagerImpl() {}

    public ThemesManagerImpl getInstance() {
    	if(this.instance == null) {
    		this.instance = new ThemesManagerImpl();
    	}
    	return this.instance;
    }

	@Override
	public List<Theme> findAll() throws ManagerException {
		List<Theme> themes = null;
		try {
			themes = themeDAO.selectAll();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return themes;
	}

	@Override
	public Theme findOne(Integer id) throws ManagerException, ElementNotFoundException {
		Theme theme = null;
		try {
			theme = themeDAO.selectById(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return theme;
	}

	@Override
	public void deleteOne(Integer id) throws ManagerException {
		try {
			themeDAO.delete(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public Theme saveOne(Theme theme) throws ManagerException, FunctionalException {
		Theme savedTheme = null;
		try {
			savedTheme = themeDAO.insert(theme);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return savedTheme;
	}

	@Override
	public List<Question> getListeQuestions(Theme theme) throws ManagerException {
		List<Question> questions = null;
		try {
			questions = questionDAO.selectByTheme(theme);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return questions;
	}

	@Override
	public Question ajouterQuestion(Theme theme, Question question) throws ManagerException {
		Question question = null;
		return null;
	}

	@Override
	public Question modifierNomQuestion(Question question, String nom) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question supprimerQuestion(Question question) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposition> getListePropositions(Question theme) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition ajouterProposition(Question question, Proposition proposition) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition modifierNomProposition(Proposition proposition, String nom) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition supprimerProposition(Proposition propsition) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

}