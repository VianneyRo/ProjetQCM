package fr.eni.projet.qcm.bll.factory;

import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bll.manager.TestsManager;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bll.manager.impl.EpreuvesManagerImpl;
import fr.eni.projet.qcm.bll.manager.impl.TestsManagerImpl;
import fr.eni.projet.qcm.bll.manager.impl.UtilisateursManagerImpl;

public class ManagerFactory {

	public static TestsManager testsManager() {
		return TestsManagerImpl.getInstance();
	}

	public static UtilisateursManager utilisateursManager() {
		return UtilisateursManagerImpl.getInstance();
	}

	public static EpreuvesManager epreuvesManager() {
		return EpreuvesManagerImpl.getInstance();
	}
}
