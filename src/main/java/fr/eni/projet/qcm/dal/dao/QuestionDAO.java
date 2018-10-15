package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface QuestionDAO {

	public List<Question> selectByThemeId(Integer themeId) throws DaoException;
	public Question selectById(Integer id) throws DaoException;

	public Question insert(Question question, Theme theme) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Question question) throws DaoException;

}
