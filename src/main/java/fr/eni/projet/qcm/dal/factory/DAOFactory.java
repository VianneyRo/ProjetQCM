package fr.eni.projet.qcm.dal.factory;

import fr.eni.projet.qcm.dal.dao.CandidatDAO;
import fr.eni.projet.qcm.dal.dao.CollaborateurDAO;
import fr.eni.projet.qcm.dal.dao.ThemeDAO;
import fr.eni.projet.qcm.dal.dao.impl.CandidatDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.CollaborateurDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.ThemeDAOImpl;

public class DAOFactory {

	public static CandidatDAO candidatDao() {
		return CandidatDAOImpl.getInstance();
	}

	public static CollaborateurDAO collaborateurDao() {
		return CollaborateurDAOImpl.getInstance();
	}

	public static ThemeDAO themeDao() {
		return ThemeDAOImpl.getInstance();
	}
}
