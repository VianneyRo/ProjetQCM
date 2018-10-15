package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class QuestionDAOImpl implements QuestionDAO
{
	
	private static final String INSERT_QUESTION_QUERY = "INSERT INTO question(themeId, enonce, media, points) VALUES(?, ?, ?, ?)";
	private static final String DELETE_QUESTION_QUERY = "DELETE FROM question WHERE id=?";
	private static final String UPDATE_QUESTION_QUERY = "UPDATE question SET enonce=?, media=?, points=? WHERE id=?";
	private static final String SELECT_BY_THEME = "SELECT id, enonce, media, points WHERE themeId=?";
	private static final String SELECT_ALL = "SELECT id, enonce, media, points FROM question";
	
	private static QuestionDAOImpl instance;
	
	private QuestionDAOImpl(){}
	
	public static QuestionDAOImpl getInstance(){
		if(instance == null){
			instance = new QuestionDAOImpl();
		}
		return instance;
	}
	
	
	
	@Override
	public Question insert(Question question, Theme theme) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question insertedQuestion = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, theme.getId());
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

	@Override
	public List<Question> selectByTheme(Theme theme) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Question> questions = new ArrayList<Question>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_THEME, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, theme.getId());

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				questions.add(resultSetToQuestion(resultSet));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}

		return questions;
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

	@Override
	public List<Question> selectByEpreuve(Test test) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectAll() throws DaoException {
		List<Question> listeQuestions = new ArrayList<Question>();
		Question question = null;
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			statement = connexion.prepareStatement(SELECT_ALL);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				question = new Question();
				question.setEnonce(resultSet.getString("enonce"));
				listeQuestions.add(question);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return listeQuestions;
	}
}
