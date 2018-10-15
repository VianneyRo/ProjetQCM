package fr.eni.projet.qcm.bll.manager.impl;

import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Promotion;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class UtilisateursManagerImpl implements UtilisateursManager {
	private UtilisateurDAO utilisateurDao;
	private static UtilisateursManagerImpl instance;

	public static UtilisateursManagerImpl getInstance() {
		if(instance == null) {
			instance = new UtilisateursManagerImpl();
		}
		return instance;
	}

	@Override
	public Utilisateur connexion(String login, String password) throws ManagerException {
		Utilisateur utilisateur = null;
		try {
			Utilisateur utilisateurConnecte = utilisateurDao.connexion(login, password);
			if(utilisateurConnecte == null) {
				throw new Exception();
			} else {
				utilisateur = utilisateurConnecte;
			}
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return utilisateur;
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
