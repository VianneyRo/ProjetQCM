package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;


public interface ThemesManager {

    List<Theme> findAll() throws ManagerException;
    Theme findOne(Integer id) throws ManagerException, ElementNotFoundException;
    void deleteOne(Integer id) throws ManagerException;
    Theme saveOne(Theme theme) throws ManagerException, FunctionalException;

    Question ajouterQuestion(Theme theme, Question question) throws ManagerException;
    Question supprimerQuestion(Question question) throws ManagerException;

    Proposition ajouterProposition(Question question, Proposition proposition) throws ManagerException;
    Proposition supprimerProposition(Proposition propsition) throws ManagerException;
}
