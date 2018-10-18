package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.QuestionTirage;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface QuestionTirageDAO {

	public List<QuestionTirage> selectByEpreuveId(Integer epreuveId) throws DaoException;
	public QuestionTirage selectById(Integer id) throws DaoException;

	public QuestionTirage insert(QuestionTirage question, Integer epreuveId) throws DaoException;
}
