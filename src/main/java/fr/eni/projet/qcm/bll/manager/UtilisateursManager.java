package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Promotion;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface UtilisateursManager {

	Utilisateur connexion(String login, String password) throws ManagerException;
	List<Utilisateur> selectAll() throws ManagerException;
	void ajouterUtilisateur(Utilisateur utilisateur) throws ManagerException;
	void supprimerUtilisateur(Integer utilisateurId) throws ManagerException;

	Profil selectProfilByUtilisateurId(Integer utilisateurId) throws ManagerException;
	void ajouterProfil(Profil profil) throws ManagerException;
	void modifierProfil(Profil profil) throws ManagerException;
	void supprimerProfil(Profil profil) throws ManagerException;

	void ajouterPromotion(Promotion promotion) throws ManagerException;
	void modifierPromotion(Promotion promotion) throws ManagerException;
	void supprimerPromotion(Promotion promotion) throws ManagerException;

}
