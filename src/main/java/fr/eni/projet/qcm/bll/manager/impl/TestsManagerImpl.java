package fr.eni.projet.qcm.bll.manager.impl;

import java.util.List;

import fr.eni.projet.qcm.bll.manager.TestsManager;
import fr.eni.projet.qcm.bo.SectionTest;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class TestsManagerImpl implements TestsManager {
	private static TestsManagerImpl instance;

	public TestsManagerImpl getInstance() {
		if(instance == null) {
			instance = new TestsManagerImpl();
		}
		return instance;
	}

	@Override
	public List<Test> getAllTests() throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test getTestById(Integer id) throws ManagerException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterTest(Test test) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierTest(Test test) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerTest(Test test) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SectionTest> getSectionsTest(Test test) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterSectionTest(Test test, SectionTest sectionTest) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierSectionTest(SectionTest sectionTest) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerSectionTest(SectionTest sectionTest) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

}
