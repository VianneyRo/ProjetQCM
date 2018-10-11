package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface QuestionsManager {
	
	Question insert(Question question) throws ManagerException;
	
	List<Question> selectAll() throws ManagerException;
	
	void deleteById(int id) throws ManagerException;

	Question selectByEnonce(String enonce) throws ManagerException;
}
