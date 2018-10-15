package fr.eni.projet.qcm.bll.manager.impl;

import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Admin;
import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Promotion;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class UtilisateursManagerImpl implements UtilisateursManager {
	private UtilisateurDAO utilisateurDao = DAOFactory.utilisateurDAO();
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
			return new Collaborateur(1, "Ollaborateur", "Charles", "collaborateur@eni.fr", "collaborateur");
		} else if((login.equals("c.andidat17@eni.fr") || login.equals("c.andidat18@eni.fr")) && password.equals("candidat")) {
			return new Candidat(1, "Andidat", "Cédric", "candidat@eni.fr", "candidat");
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
