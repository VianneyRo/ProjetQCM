package fr.eni.projet.qcm.bll.factory;

import fr.eni.projet.qcm.bll.manager.TestManager;
import fr.eni.projet.qcm.bll.manager.impl.TestManagerImpl;

public class ManagerFactory {
	public static TestManager testManager() {
		return TestManagerImpl.getInstance();
	}
}
