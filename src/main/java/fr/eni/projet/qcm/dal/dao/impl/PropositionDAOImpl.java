package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.dao.PropositionDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class PropositionDAOImpl implements PropositionDAO {
	private static final String SELECT_BY_ID = "SELECT id, enonce, correcte WHERE id=?";
	private static final String SELECT_BY_QUESTION = "SELECT id, enonce, correcte WHERE idQuestion=?";
	private static final String INSERT = "INSERT INTO proposition(questionId, enonce, correcte) VALUES(?, ?, ?)";
	private static final String DELETE = "DELETE FROM proposition WHERE id=?";
	private static final String UPDATE = "UPDATE proposition SET enonce=?, correcte=? WHERE id=?";
	private static PropositionDAOImpl instance;

	private PropositionDAOImpl() {}

	public static PropositionDAOImpl getInstance() {
		if(instance == null) {
			instance = new PropositionDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Proposition> selectByQuestionId(Integer questionId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Proposition> propositions = new ArrayList<Proposition>();
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_QUESTION, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, questionId);

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				propositions.add(resultSetToProposition(resultSet));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return propositions;
	}

	@Override
	public Proposition selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition proposition = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_ID, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			proposition = resultSetToProposition(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return proposition;
	}

	@Override
	public Proposition insert(Proposition proposition, Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition insertedProposition = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, question.getId());
			statement.setString(2, proposition.getEnonce());
			statement.setBoolean(3, proposition.isCorrecte());

			resultSet = statement.executeQuery();
			insertedProposition = resultSetToProposition(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return insertedProposition;
	}

	@Override
	public void delete(Integer propositionId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, propositionId);
			statement.executeQuery();
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void update(Integer propositionId, Proposition proposition) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, proposition.getEnonce());
			statement.setBoolean(2, proposition.isCorrecte());
			statement.setInt(3, proposition.getId());
			statement.executeQuery();
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	private Proposition resultSetToProposition(ResultSet resultSet) throws DaoException {
		Proposition proposition = null;
		try {
			proposition = new Proposition();
			proposition.setId(resultSet.getInt("id"));
			proposition.setEnonce(resultSet.getString("enonce"));
			proposition.setCorrecte(resultSet.getBoolean("correcte"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return proposition;
	}

}
