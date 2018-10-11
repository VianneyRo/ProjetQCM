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
	private static final String INSERT_PROPOSITION_QUERY = "INSERT INTO proposition(questionId, enonce, correcte) VALUES(?, ?, FALSE)";
	private static final String DELETE_PROPOSITION_QUERY = "DELETE FROM proposition WHERE id=?";
	private static final String UPDATE_PROPOSITION_QUERY = "UPDATE proposition SET enonce=?, correcte=? WHERE id=?";
	private static final String SELECT_BY_QUESTION = "SELECT id, enonce, correcte WHERE idQuestion=?";
	private PropositionDAOImpl instance;

	private PropositionDAOImpl() {}

	public PropositionDAOImpl getInstance() {
		if(this.instance == null) {
			this.instance = new PropositionDAOImpl();
		}
		return this.instance;
	}

	@Override
	public Proposition insert(Proposition proposition, Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition insertedProposition = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT_PROPOSITION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, question.getId());
			statement.setString(2, proposition.getEnonce());

			resultSet = statement.executeQuery();
			insertedProposition = resultSetToProposition(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return insertedProposition;
	}

	@Override
	public Proposition delete(Proposition proposition) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition deletedProposition = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(DELETE_PROPOSITION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, proposition.getId());

			resultSet = statement.executeQuery();
			deletedProposition = resultSetToProposition(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return deletedProposition;
	}

	@Override
	public Proposition update(Proposition proposition) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition updatedProposition = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(UPDATE_PROPOSITION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, proposition.getEnonce());
			statement.setBoolean(2, proposition.isCorrecte());
			statement.setInt(3, proposition.getId());

			resultSet = statement.executeQuery();
			updatedProposition = resultSetToProposition(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return updatedProposition;
	}

	@Override
	public List<Proposition> selectByQuestion(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Proposition> propositions = new ArrayList<Proposition>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_QUESTION, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, question.getId());

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				propositions.add(resultSetToProposition(resultSet));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}

		return propositions;
	}

	private Proposition resultSetToProposition(ResultSet resultSet) throws DaoException {
		Proposition proposition = new Proposition();
		try {
			proposition.setId(resultSet.getInt("id"));
			proposition.setEnonce(resultSet.getString("enonce"));
			proposition.setCorrecte(resultSet.getBoolean("correcte"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return proposition;
	}

}
