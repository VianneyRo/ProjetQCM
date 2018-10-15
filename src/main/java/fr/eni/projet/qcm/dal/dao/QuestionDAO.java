package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface QuestionDAO {

	public Question insert(Question question, Theme theme) throws DaoException;
	public Question delete(Question question) throws DaoException;
	public Question update(Question question) throws DaoException;
	public List<Question> selectByTheme(Theme theme) throws DaoException;
	public List<Question> selectByEpreuve(Test test) throws DaoException;
	public List<Question> selectAll() throws DaoException;
}
