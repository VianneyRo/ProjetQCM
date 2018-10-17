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

public class ThemesManagerImpl implements ThemesManager {


    private ThemeDAO themeDAO = DAOFactory.themeDao();
    private QuestionDAO questionDAO = DAOFactory.questionDao();
    private PropositionDAO propositionDAO = DAOFactory.propositionDao();
    private static ThemesManagerImpl instance;

    private ThemesManagerImpl() {}

    public static ThemesManagerImpl getInstance() {
    	if(instance == null) {
    		instance = new ThemesManagerImpl();
    	}
    	return instance;
    }

	@Override
	public List<Theme> getAllThemes() throws ManagerException {
		List<Theme> themes = null;
		try {
			themes = themeDAO.selectAll();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return themes;
	}

	@Override
	public Theme getThemeById(Integer id) throws ManagerException, ElementNotFoundException {
		Theme theme = null;
		try {
			theme = themeDAO.selectById(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return theme;
	}

	@Override
	public void ajouterTheme(Theme theme) throws ManagerException {
		try {
			Theme insertedTheme = themeDAO.insert(theme);
			for(Question question: theme.getQuestions()) {
				this.ajouterQuestion(insertedTheme, question);
			}
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void supprimerTheme(Integer id) throws ManagerException {
		try {
			themeDAO.delete(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public Theme modifierTheme(Theme theme) throws ManagerException {
		Theme savedTheme = null;
		try {
			savedTheme = themeDAO.insert(theme);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return savedTheme;
	}

	@Override
	public List<Question> getQuestions(Theme theme) throws ManagerException {
		List<Question> questions = null;
		try {
			questions = questionDAO.selectByThemeId(theme.getId());
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return questions;
	}

	@Override
	public void ajouterQuestion(Theme theme, Question question) throws ManagerException {
		try {
			Question insertedQuestion = questionDAO.insert(question, theme);
			for(Proposition proposition: question.getPropositions()) {
				this.ajouterProposition(insertedQuestion, proposition);
			}
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void modifierQuestion(Question question) throws ManagerException {
		try {
			questionDAO.update(question.getId(), question);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void supprimerQuestion(Theme theme, Question question) throws ManagerException {
		try {
			questionDAO.delete(question.getId());
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public List<Proposition> getPropositions(Question question) throws ManagerException {
		List<Proposition> propositions = new ArrayList<Proposition>();
		try {
			propositions = propositionDAO.selectByQuestionId(question.getId());
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return propositions;
	}

	@Override
	public void ajouterProposition(Question question, Proposition proposition) throws ManagerException {
		try {
			propositionDAO.insert(proposition, question);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void modifierProposition(Proposition proposition) throws ManagerException {
		try {
			propositionDAO.update(proposition.getId(), proposition);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void supprimerProposition(Question question, Proposition proposition) throws ManagerException {
		try {
			propositionDAO.delete(proposition.getId());
			question.supprimerProposition(proposition);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

}