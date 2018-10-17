package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Promotion;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.dao.ProfilDAO;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

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
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurDao.connexion(login, password);
			System.out.println("Utilisateur: [nom=" + utilisateur.getNom() + ", prenom= " + utilisateur.getPrenom() + ", profil=" + utilisateur.getProfil() + "]");
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws ManagerException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			utilisateurs = utilisateurDao.selectAll();
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
		Profil profil = null;
		try {
			profil = profilDao.selectByUtilisateurId(utilisateurId);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return profil;
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

	@Override
	public List<Utilisateur> getAllCollaborateurs() throws ManagerException {
		List<Utilisateur> collaborateurs = null;
		try {
			collaborateurs = utilisateurDao.selectAllCollaborateur();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return collaborateurs;
	}

	@Override
	public List<Utilisateur> getAllCandidats() throws ManagerException {
		List<Utilisateur> candidats = null;
		try {
			candidats = utilisateurDao.selectAllCandidat();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return candidats;
	}

	@Override
	public Utilisateur insert(Utilisateur unCollaborateur) throws ManagerException {
		Utilisateur collaborateur = null;
		
		ValidationUtil.checkNotNull(unCollaborateur);
		
		try {
			collaborateur = utilisateurDao.insert(unCollaborateur);
		} catch (DaoException e) {
			throw new ManagerException("Erreur DAO", e);
		}
		return collaborateur;
		
	}

}
