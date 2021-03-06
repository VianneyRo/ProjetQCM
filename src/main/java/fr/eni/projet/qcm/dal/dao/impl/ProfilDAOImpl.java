package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.dal.dao.ProfilDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class ProfilDAOImpl implements ProfilDAO {
	private static final String SELECT_BY_UTILISATEUR = "SELECT p.code, p.libelle FROM profil p, utilisateur u WHERE u.id=? AND u.code_profil=p.code";
//	private static final String INSERT = "INSERT INTO profil(code, libelle) VALUES(?, ?)";
//	private static final String DELETE = "DELETE FROM profil WHERE id=?";
//	private static final String UPDATE = "UPDATE profil SET code=?, libelle=? WHERE id=?";
	private static ProfilDAOImpl instance;

	private ProfilDAOImpl() {}

	public static ProfilDAOImpl getInstance() {
		if(instance == null) {
			instance = new ProfilDAOImpl();
		}
		return instance;
	}

	@Override
	public Profil selectByUtilisateurId(Integer utilisateurId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Profil profil = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_UTILISATEUR);
			statement.setInt(1, utilisateurId);

			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				profil = resultSetToProfil(resultSet);
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return profil;
	}

	@Override
	public Profil insert(Profil profil) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer profilId) throws DaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Integer profilId, Profil profil) throws DaoException {
		// TODO Auto-generated method stub
	}

	private Profil resultSetToProfil(ResultSet resultSet) throws DaoException {
		Profil profil = null;
		try {
			profil = new Profil();
			profil.setCode(resultSet.getString("code"));
			profil.setLibelle(resultSet.getString("libelle"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return profil;
	}

}
