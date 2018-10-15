package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.bo.Admin;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private static final String LOGIN = "SELECT id, nom, prenom, email, code_profil FROM utilisateur WHERE email=? AND password=?";

	private static UtilisateurDAOImpl instance;

	public static UtilisateurDAOImpl getInstance() {
		if(instance == null) {
			instance = new UtilisateurDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Utilisateur> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur connexion(String email, String password) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Utilisateur utilisateur = null;
		
		try {
			System.out.println("Connexion: [email=" + email + ", password=" + password + "]");
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(LOGIN, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, email);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			utilisateur = resultSetToUtilisateur(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	
		return utilisateur;
	}

	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws DaoException {
		return null;
	}

	@Override
	public void delete(Integer id) throws DaoException {
		
	}

	@Override
	public void update(Integer id, Utilisateur utilisateur) throws DaoException {
		
	}

	private Utilisateur resultSetToUtilisateur(ResultSet resultSet) throws DaoException {
		Utilisateur utilisateur = null;
		try {
			if(resultSet.getString("code_profil") != null) {
				switch(resultSet.getString("code_profil")) {
					case "CAND":
						utilisateur = new Candidat();
						break;
					case "COLL":
						utilisateur = new Collaborateur();
						break;
					case "ADMIN":
						utilisateur = new Admin();
						break;
				}
				utilisateur.setId(resultSet.getInt("id"));
				utilisateur.setNom(resultSet.getString("nom"));
				utilisateur.setPrenom(resultSet.getString("prenom"));
				utilisateur.setEmail(resultSet.getString("email"));
				utilisateur.setProfil(resultSet.getString("code_profil"));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return utilisateur;
	}

}
