package fr.eni.projet.qcm.dal.dao;

import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface ProfilDAO {

	Profil selectByUtilisateurId(Integer utilisateurId) throws DaoException;

	public Profil insert(Profil profil) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Profil profil) throws DaoException;

}
