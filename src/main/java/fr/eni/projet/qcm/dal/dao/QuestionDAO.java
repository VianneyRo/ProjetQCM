package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface QuestionDAO {

	public Question insert(Question question, Integer themeId) throws DaoException;
	public Question delete(Question question) throws DaoException;
	public Question update(Question question) throws DaoException;

	Question save(Integer id, Question question);

	Question delete(Question question);

}
