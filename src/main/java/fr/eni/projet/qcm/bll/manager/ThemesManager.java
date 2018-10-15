package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;


public interface ThemesManager {

    List<Theme> getAllThemes() throws ManagerException;
    Theme getThemeById(Integer id) throws ManagerException, ElementNotFoundException;
    void ajouterTheme(Theme theme) throws ManagerException;
    void supprimerTheme(Theme theme) throws ManagerException;
    Theme modifierTheme(Theme theme) throws ManagerException;
    List<Question> getQuestions(Theme theme) throws ManagerException;

    void ajouterQuestion(Theme theme, Question question) throws ManagerException;
    void modifierQuestion(Question question) throws ManagerException;
    void supprimerQuestion(Theme theme, Question question) throws ManagerException;
    List<Proposition> getPropositions(Question question) throws ManagerException;

    void ajouterProposition(Question question, Proposition proposition) throws ManagerException;
    void modifierProposition(Proposition proposition) throws ManagerException;
    void supprimerProposition(Question question, Proposition proposition) throws ManagerException;

}
