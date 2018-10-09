package fr.eni.projet.qcm.bll.manager.impl;

import java.util.List;

import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public class ThemesManagerImpl implements ThemesManager {

    private ThemeDAO themeDAO = DAOFactory.themeDAO();
    private QuestionDAO questionDAO = DAOFactory.questionDAO();
    private PropositionDAO propositionDAO = DAOFactory.propositionDAO();
    private static ThemesManagerImpl instance;

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
			theme = themeDAO.selectOne(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return theme;
	}

	@Override
	public void deleteOne(Integer id) throws ManagerException {
		try {
			themeDAO.deleteOne(id);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public Theme saveOne(Theme theme) throws ManagerException, FunctionalException {
		Theme savedTheme = null;
		try {
			savedTheme = themeDAO.save(theme);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return savedTheme;
	}

	@Override
	public Question ajouterQuestion(Theme theme, Question question) throws ManagerException {
		Question savedQuestion = null;
		try {
			savedQuestion = questionDAO.save(theme, question);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return savedQuestion;
	}

	@Override
	public Question supprimerQuestion(Question question) throws ManagerException {
		Question deletedQuestion = null;
		try {
			deletedQuestion = questionDAO.delete(question);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return deletedQuestion;
	}

	@Override
	public Proposition ajouterProposition(Question question, Proposition proposition) throws ManagerException {
		Proposition savedProposition = null;
		try {
			savedProposition = propositionDAO.save(question, proposition);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return savedProposition;
	}

	@Override
	public Proposition supprimerProposition(Proposition propsition) throws ManagerException {
		Proposition deletedProposition = null;
		try {
			deletedProposition = propositionDAO.delete(proposition);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return deletedProposition;
	}

}