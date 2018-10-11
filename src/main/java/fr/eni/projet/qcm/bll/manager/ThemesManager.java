package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;


public interface ThemesManager {

    List<Theme> getAllThemes() throws ManagerException;
    Theme getTheme(Integer id) throws ManagerException, ElementNotFoundException;
    void ajouterTheme(Theme theme) throws ManagerException;
    void supprimerTheme(Integer id) throws ManagerException;
    Theme modifierTheme(Theme theme) throws ManagerException;
    List<Question> getQuestions(Theme theme) throws ManagerException;

    void ajouterQuestion(Theme theme, Question question) throws ManagerException;
    void modifierEnonceQuestion(Question question, String enonce) throws ManagerException;
    void modifierMediaQuestion(Question question, String media) throws ManagerException;
    void modifierPointsQuestion(Question question, Integer points) throws ManagerException;
    void supprimerQuestion(Theme theme, Question question) throws ManagerException;
    List<Proposition> getPropositions(Question question) throws ManagerException;

    void ajouterProposition(Question question, Proposition proposition) throws ManagerException;
    void modifierEnonceProposition(Proposition proposition, String enonce) throws ManagerException;
    void modifierCorrecteProposition(Proposition proposition, boolean correcte) throws ManagerException;
    void supprimerProposition(Question question, Proposition proposition) throws ManagerException;

}
