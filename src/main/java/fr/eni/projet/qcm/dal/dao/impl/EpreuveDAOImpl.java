package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.dal.util.DateUtil;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.dal.dao.EpreuveDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class EpreuveDAOImpl implements EpreuveDAO {

	private static final String SELECT_ALL_EPREUVES_QUERY = "SELECT e.dateDebutValidite, e.dateFinValidite, e.tempsEcoule, e.noteObtenue, e.niveauObtenu, e.etat FROM epreuve e ORDER BY e.etat DESC";
	private static final String SELECT_ONE_EPREUVE_QUERY = "SELECT e.id, e.dateDebutValidite, e.dateFinValidite, e.tempsEcoule, e.noteObtenue, e.niveauObtenu, e.etat FROM epreuve e WHERE e.id = ?";
	private static final String SELECT_ONE_EPREUVE_BY_NOTE_QUERY = "SELECT e.id FROM epreuve e WHERE e.noteObtenue = ?";
	private static final String INSERT_EPREUVE_QUERY = "INSERT INTO epreuve(dateDebutValidite, dateFinValidite, tempsEcoule, note_obtenue, niveau_obtenu, etat) VALUES(?,?,?,?,?,?) ";
	private static final String DELETE_EPREUVE_QUERY = "DELETE FROM epreuve WHERE id = ? ";
	private static final String UPDATE_EPREUVE_QUERY = "UPDATE epreuve SET dateDebutValidite = ?, dateFinValidite = ?, tempsEcoule = ?, noteObtenue = ?, niveauObtenu = ?, etat = ? WHERE id = ?";

	private static EpreuveDAOImpl instance;

	private EpreuveDAOImpl() {

	}

	public static EpreuveDAOImpl getInstance() {
		if (instance == null) {
			instance = new EpreuveDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Epreuve> selectByCandidatId(Integer candidatId) throws DaoException {
		return null;
	}
	@Override
	public Epreuve selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Epreuve epreuve = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_ONE_EPREUVE_QUERY);

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				epreuve = resultSetToNote(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return epreuve;
	}

	@Override
	public List<Epreuve> selectAll() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Epreuve> list = new ArrayList<>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_EPREUVES_QUERY);

			while (resultSet.next()) {
				list.add(resultSetToNote(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return list;
	}

	@Override
	public Epreuve insert(Epreuve epreuve) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_EPREUVE_QUERY, Statement.RETURN_GENERATED_KEYS);
			
			statement.setDate(1, DateUtil.UtilDateToJDBCDate(epreuve.getDateDebutValidite()));
			statement.setDate(2, DateUtil.UtilDateToJDBCDate(epreuve.getDateFinValidite()));
			statement.setLong(3, epreuve.getTempsEcoule());
			statement.setString(4, epreuve.getEtat());
			statement.setFloat(5, epreuve.getNoteObtenue());
			statement.setString(6, epreuve.getNiveauObtenu());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					epreuve.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return epreuve;
	}

	@Override
	public void update(Integer epreuveId, Epreuve epreuve) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_EPREUVE_QUERY);

			statement.setDate(1, DateUtil.UtilDateToJDBCDate(epreuve.getDateDebutValidite()));
			statement.setDate(2, DateUtil.UtilDateToJDBCDate(epreuve.getDateFinValidite()));
			statement.setLong(3, epreuve.getTempsEcoule());
			statement.setString(4, epreuve.getEtat());
			statement.setFloat(5, epreuve.getNoteObtenue());
			statement.setString(6, epreuve.getNiveauObtenu());
			statement.setInt(7, epreuve.getId());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(DELETE_EPREUVE_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	private Epreuve resultSetToNote(ResultSet resultSet) throws SQLException {
		Epreuve epreuve = new Epreuve();
		epreuve.setId(resultSet.getInt("idEpreuve"));
		epreuve.setDateDebutValidite(DateUtil.JDBCDateToUtilDate(resultSet.getDate("dateDebutValidite")));		
		epreuve.setDateFinValidite(DateUtil.JDBCDateToUtilDate(resultSet.getDate("dateFinValidite")));
		epreuve.setTempsEcoule(resultSet.getLong("tempsEcoule"));
		epreuve.setEtat(resultSet.getString("etat"));
		epreuve.setNoteObtenue(resultSet.getFloat("note_obtenue"));
		epreuve.setNiveauObtenu(resultSet.getString("niveau_obtenu"));
		return epreuve;
	}
}
