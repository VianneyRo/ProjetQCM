package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class QuestionDAOImpl implements QuestionDAO {
	private static final String SELECT_BY_THEME = "SELECT id, enonce, media, points FROM question WHERE id_theme=?";
	private static final String SELECT_BY_QUESTION_TIRAGE = "SELECT q.id, q.enonce, q.media, q.points FROM question q, question_tirage qt WHERE q.id=? AND q.id_question=qt.id";
	private static final String SELECT_BY_ID = "SELECT id, enonce, media, points FROM question WHERE id=?";
//	private static final String INSERT = "INSERT INTO question(themeId, enonce, media, points) VALUES(?, ?, ?, ?)";
//	private static final String DELETE = "DELETE FROM question WHERE id=?";
//	private static final String UPDATE = "UPDATE question SET enonce=?, media=?, points=? WHERE id=?";
	private static QuestionDAOImpl instance;

	public static QuestionDAOImpl getInstance() {
		if(instance == null) {
			instance = new QuestionDAOImpl();
		}
		return instance;
	}

	@Override
	public List<Question> selectByThemeId(Integer themeId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Question> questions = new ArrayList<Question>();
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_THEME);
			statement.setInt(1, themeId);

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				questions.add(resultSetToQuestion(resultSet));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return questions;
	}

	@Override
	public Question selectByQuestionTirageId(Integer questionTirageId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question question = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_QUESTION_TIRAGE);
			statement.setInt(1, questionTirageId);

			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				question = resultSetToQuestion(resultSet);
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question;
	}

	@Override
	public Question selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question question = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_ID);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				question = resultSetToQuestion(resultSet);
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question;
	}


	@Override
	public Question insert(Question question, Theme theme) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Integer questionId) throws DaoException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Integer questionId, Question question) throws DaoException {
		// TODO Auto-generated method stub
		
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
