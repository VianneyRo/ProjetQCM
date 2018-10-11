package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.tp.web.common.dal.dao.GenericDAO;

public interface PropositionDAO extends GenericDAO<Proposition, Integer>{

	Proposition save(Question question, Proposition proposition);

	Proposition delete(Proposition proposition);

}
