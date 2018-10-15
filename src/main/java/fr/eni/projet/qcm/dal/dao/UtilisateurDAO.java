package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface UtilisateurDAO {

	public List<Utilisateur> selectAll() throws DaoException;
	public Utilisateur selectById(Integer id) throws DaoException;
	public Utilisateur connexion(String login, String password) throws DaoException;

	public Utilisateur insert(Utilisateur utilisateur) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Utilisateur utilisateur) throws DaoException;

}
