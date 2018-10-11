package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface TestManager {
	
	Test insert(Test test) throws ManagerException;
	
	List<Test> selectAll() throws ManagerException;
	
	void deleteById(int id) throws ManagerException;
	
	Test selectByLibelle(String libelle) throws ManagerException;
}
