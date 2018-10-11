package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.tp.web.common.dal.dao.GenericDAO;

public interface QuestionDAO extends GenericDAO<Question, Integer> {

	Question save(Integer id, Question question);

	Question delete(Question question);

}
