package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.dal.dao.GenericDAO;

public interface ThemeDAO extends GenericDAO<Theme, Integer	> {
	public Question ajouterQuestion(Theme theme, Question question);
	public Question retirerQuestion(Question question);
	public Proposition ajouterProposition(Question question, Proposition proposition);
	public Proposition retirerProposition(Proposition proposition);
}
