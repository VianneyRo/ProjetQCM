package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Admin;
import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Promotion;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.dao.ProfilDAO;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class UtilisateursManagerImpl implements UtilisateursManager {
	private UtilisateurDAO utilisateurDao = DAOFactory.utilisateurDAO();
	private ProfilDAO profilDao = DAOFactory.profilDAO();
	private static UtilisateursManagerImpl instance;

	public static UtilisateursManagerImpl getInstance() {
		if(instance == null) {
			instance = new UtilisateursManagerImpl();
		}
		return instance;
	}

	@Override
	public Utilisateur connexion(String login, String password) throws ManagerException {
		System.out.println("login: " + login + ", password: " + password);
		if(login.equals("a.dmin@eni.fr") && password.equals("admin")) {
			return new Admin(1, "Dmin", "Alain", "admin@eni.fr", "admin");
		} else if(login.equals("c.ollaborateur@eni.fr") && password.equals("collaborateur")) {
			return new Collaborateur(2, "Ollaborateur", "Charles", "collaborateur@eni.fr", "collaborateur");
		} else if((login.equals("c.andidat17@eni.fr") || login.equals("c.andidat18@eni.fr")) && password.equals("candidat")) {
			return new Candidat(3, "Andidat", "Cédric", "candidat@eni.fr", "candidat", "CDI17");
		} else {
			throw new ManagerException("Pb de connexion", null);
		}
//		Utilisateur utilisateur = null;
//		try {
//			Utilisateur utilisateurConnecte = utilisateurDao.connexion(login, password);
//			if(utilisateurConnecte == null) {
//				throw new Exception();
//			} else {
//				System.out.println("Utilisateur: [nom=" + utilisateurConnecte.getNom() + ", prenom= " + utilisateurConnecte.getPrenom() + ", profil=" + utilisateurConnecte.getProfil() + "]");
//				utilisateur = utilisateurConnecte;
//			}
//		} catch(Exception e) {
//			throw new ManagerException(e.getMessage(), e);
//		}
//		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws ManagerException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			utilisateurs.add(new Candidat(1, "Anvers", "Alain", "anvers.alain@eni.fr", "candidat", "CDI17"));
			utilisateurs.add(new Collaborateur(2, "Belvier", "Bernard", "belvier.bernard@eni.fr", "collaborateur"));
			utilisateurs.add(new Collaborateur(3, "Crouton", "Charles", "crouton.charles@eni.fr", "collaborateur"));
			utilisateurs.add(new Candidat(4, "Delaville", "Denis", "delaville.denis@eni.fr", "candidat", "CDI17"));
			utilisateurs.add(new Candidat(5, "Épervier", "Édouard", "epervier.edouard@eni.fr", "candidat", "CDI18"));
//			utilisateurs = utilisateurDao.selectAll();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return utilisateurs;
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws ManagerException {
		try {
			utilisateurDao.insert(utilisateur);
		} catch (DaoException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public void supprimerUtilisateur(Integer utilisateurId) throws ManagerException {
		try {
			utilisateurDao.delete(utilisateurId);
		} catch (DaoException e) {
			throw new ManagerException(e.getMessage(), e);
		}
	}

	@Override
	public Profil selectProfilByUtilisateurId(Integer utilisateurId) throws ManagerException {
//		Profil profil = null;
//		try {
//			profil = profilDao.selectByUtilisateurId(utilisateurId);
//		} catch(Exception e) {
//			throw new ManagerException(e.getMessage(), e);
//		}
//		return profil;
		switch(utilisateurId) {
			case 1: return new Profil("ADMIN", "admin");
			case 2: return new Profil("COLL", "collaborateur");
			default: return new Profil("CAND", "candidat");
		}
	}

	@Override
	public void ajouterProfil(Profil profil) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierProfil(Profil profil) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerProfil(Profil profil) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterPromotion(Promotion promotion) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierPromotion(Promotion promotion) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerPromotion(Promotion promotion) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

}
