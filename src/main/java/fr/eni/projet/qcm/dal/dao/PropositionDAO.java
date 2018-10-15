package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface PropositionDAO {

	public List<Proposition> selectByQuestionId(Integer questionId) throws DaoException;
	public Proposition selectById(Integer id) throws DaoException;

	public Proposition insert(Proposition proposition, Question question) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Proposition proposition) throws DaoException;

}
