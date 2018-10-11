package fr.eni.projet.qcm.bll.factory;

import fr.eni.projet.qcm.bll.manager.TestManager;
import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bll.manager.impl.TestManagerImpl;
import fr.eni.projet.qcm.bll.manager.impl.ThemesManagerImpl;

public class ManagerFactory {
	
	
	public static TestManager testManager() {
		return TestManagerImpl.getInstance();
	}
	
	public static ThemesManager themesManager() {
		return ThemesManagerImpl.getInstance();
	}
	
}
