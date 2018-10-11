package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface PropositionDAO {

	public Proposition insert(Proposition proposition, Question question) throws DaoException;
	public Proposition delete(Proposition proposition) throws DaoException;
	public Proposition update(Proposition proposition) throws DaoException;
	public List<Proposition> selectByQuestion(Question question) throws DaoException;

}
