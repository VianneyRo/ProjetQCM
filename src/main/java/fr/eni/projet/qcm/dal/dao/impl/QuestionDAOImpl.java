package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class QuestionDAOImpl implements QuestionDAO {
	private static final String INSERT_QUESTION_QUERY = "INSERT INTO question(themeId, enonce, media, points) VALUES(?, ?, ?, ?)";
	private static final String DELETE_QUESTION_QUERY = "DELETE FROM question WHERE id=?";
	private static final String UPDATE_QUESTION_QUERY = "UPDATE question SET enonce=?, media=?, points=? WHERE id=?";

	@Override
	public Question insert(Question question, Integer themeId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question insertedQuestion = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, themeId);
			statement.setString(2, question.getEnonce());
			statement.setString(3, question.getMedia());
			statement.setInt(4, question.getPoints());

			resultSet = statement.executeQuery();
			insertedQuestion = resultSetToQuestion(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return insertedQuestion;
	}

	@Override
	public Question delete(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question deletedQuestion = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(DELETE_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, question.getId());

			resultSet = statement.executeQuery();
			deletedQuestion = resultSetToQuestion(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return deletedQuestion;
	}

	@Override
	public Question update(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question updatedQuestion = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(UPDATE_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, question.getEnonce());
			statement.setString(2, question.getMedia());
			statement.setInt(3, question.getPoints());
			statement.setInt(4, question.getId());

			resultSet = statement.executeQuery();
			updatedQuestion = resultSetToQuestion(resultSet);
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}

		return updatedQuestion;
	}

	private Question resultSetToQuestion(ResultSet resultSet) throws DaoException {
		Question question = null;
		try {
			question = new Question();
			question.setId(resultSet.getInt("id"));
			question.setEnonce(resultSet.getString("enonce"));
			question.setMedia(resultSet.getString("media"));
			question.setPoints(resultSet.getInt("points"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question;
	}

}
