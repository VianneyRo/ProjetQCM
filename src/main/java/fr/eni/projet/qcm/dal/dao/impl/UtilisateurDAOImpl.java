package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.projet.qcm.bo.Admin;
import fr.eni.projet.qcm.dal.dao.UtilisateurDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private static final String LOGIN = "SELECT id, nom, prenom, email, code_profil FROM utilisateur WHERE email=? AND password=?";
	private static final String SELECT_ALL = "SELECT id, nom, prenom, email, code_profil FROM utilisateur";
	private static final String SELECT_ALL_COLLABORATEUR = "SELECT id, nom, prenom, email FROM utilisateur WHERE code_profil='COLL'";
	private static final String SELECT_ALL_CANDIDAT = "SELECT id, nom, prenom, email, code_promotion FROM utilisateur WHERE code_profil='CAND'";

	private static UtilisateurDAOImpl instance;

	public static UtilisateurDAOImpl getInstance() {
		if(instance == null) {
			instance = new UtilisateurDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Utilisateur> selectAll() throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_ALL);

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				utilisateurs.add(resultSetToUtilisateur(resultSet));
			}
		} catch(Exception e) {
			
		}		
		return utilisateurs;
	}

	@Override
	public List<Utilisateur> selectAllCollaborateur() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Utilisateur> collaborateurs = new ArrayList<Utilisateur>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_COLLABORATEUR);
			while (resultSet.next()) {
				collaborateurs.add(resultSetToCollaborateur(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return collaborateurs;
	}

	@Override
	public List<Utilisateur> selectAllCandidat() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Utilisateur> candidats = new ArrayList<Utilisateur>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_CANDIDAT);
			while (resultSet.next()) {
				candidats.add(resultSetToCandidat(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return candidats;
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
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(LOGIN, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, email);
			statement.setString(2, password);

			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				utilisateur = resultSetToUtilisateur(resultSet);
			}
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
			switch(resultSet.getString("code_profil")) {
				case "CAND":
					utilisateur = resultSetToCandidat(resultSet);
					break;
				case "COLL":
					utilisateur = resultSetToCollaborateur(resultSet);
					break;
				case "ADMIN":
					utilisateur = resultSetToAdmin(resultSet);
					break;
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return utilisateur;
	}
	
	private Utilisateur resultSetToCollaborateur(ResultSet resultSet) throws DaoException {
		Collaborateur collaborateur = null;
		try {
			collaborateur = new Collaborateur();
			collaborateur.setId(resultSet.getInt("id"));
			collaborateur.setNom(resultSet.getString("nom"));
			collaborateur.setPrenom(resultSet.getString("prenom"));
			collaborateur.setEmail(resultSet.getString("email"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return collaborateur;
	}
	
	private Utilisateur resultSetToCandidat(ResultSet resultSet) throws DaoException {
		Candidat candidat = null;
		try {
			candidat = new Candidat();
			candidat.setId(resultSet.getInt("id"));
			candidat.setNom(resultSet.getString("nom"));
			candidat.setPrenom(resultSet.getString("prenom"));
			candidat.setEmail(resultSet.getString("email"));
			candidat.setProfil(resultSet.getString("code_promotion"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return candidat;
	}
	
	private Utilisateur resultSetToAdmin(ResultSet resultSet) throws DaoException {
		Admin admin = null;
		try {
			admin = new Admin();
			admin.setId(resultSet.getInt("id"));
			admin.setNom(resultSet.getString("nom"));
			admin.setPrenom(resultSet.getString("prenom"));
			admin.setEmail(resultSet.getString("email"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return admin;
	}

}
