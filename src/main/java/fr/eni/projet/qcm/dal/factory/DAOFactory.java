package fr.eni.projet.qcm.dal.factory;

import fr.eni.projet.qcm.dal.dao.PropositionDAO;
import fr.eni.projet.qcm.dal.dao.EpreuveDAO;
import fr.eni.projet.qcm.dal.dao.ProfilDAO;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.dao.QuestionTirageDAO;
import fr.eni.projet.qcm.dal.dao.TestDAO;
import fr.eni.projet.qcm.dal.dao.ThemeDAO;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.dao.impl.EpreuveDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.ProfilDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.PropositionDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.QuestionDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.QuestionTirageDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.TestDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.ThemeDAOImpl;
import fr.eni.projet.qcm.dal.dao.impl.UtilisateurDAOImpl;

public class DAOFactory {

//	public static CandidatDAO candidatDao() {
//		return CandidatDAOImpl.getInstance();
//	}
//
//	public static CollaborateurDAO collaborateurDao() {
//		return CollaborateurDAOImpl.getInstance();
//	}
	
	public static ThemeDAO themeDao(){
		return ThemeDAOImpl.getInstance();
	}

	public static TestDAO testDao() {
		return TestDAOImpl.getInstance();
	}
	
	public static QuestionDAO questionDao(){
		return QuestionDAOImpl.getInstance();
	}

	public static PropositionDAO propositionDao() {
		return PropositionDAOImpl.getInstance();
	}

	public static EpreuveDAO epreuveDao() {
		return EpreuveDAOImpl.getInstance();
	}

	public static UtilisateurDAO utilisateurDAO() {
		return UtilisateurDAOImpl.getInstance();
	}

	public static ProfilDAO profilDAO() {
		return ProfilDAOImpl.getInstance();
	}

	public static QuestionTirageDAO questionTirageDao() {
		return QuestionTirageDAOImpl.getInstance();
	}
}
