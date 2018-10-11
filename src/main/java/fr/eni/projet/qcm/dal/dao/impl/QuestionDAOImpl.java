package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.dao.QuestionDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class QuestionDAOImpl implements QuestionDAO {

	private static final String SELECT_ALL_QUESTION_QUERY = "SELECT q.enonce, q.media, q.points FROM question q ORDER BY q.id DESC";
	private static final String INSERT_QUESTION_QUERY = "INSERT INTO question(enonce, media, points) VALUES(?,?,?) ";
	private static final String DELETE_QUESTION_QUERY = "DELETE FROM question WHERE id = ? ";
	private static final String UPDATE_QUESTION_QUERY = "UPDATE question SET enonce = ?, media = ?, points = ? WHERE id = ?";

	private static QuestionDAOImpl instance;
	
	private QuestionDAOImpl(){
		
	}
	
	public static QuestionDAOImpl getInstance(){
		if (instance == null) {
			instance = new QuestionDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Question insert(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, question.getEnonce());
			statement.setString(1, question.getMedia());
			statement.setInt(1, question.getPoints());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					question.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return question;
	}

	@Override
	public void update(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_QUESTION_QUERY);

			statement.setString(1,  question.getEnonce());
			statement.setString(2,  question.getMedia());
			statement.setInt(3,  question.getPoints());
			statement.setInt(4,  question.getId());

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

			statement = connection.prepareStatement(DELETE_QUESTION_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		
	}

	/**
	 * Note use
	 */
	@Override
	public Question selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> selectAll() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Question> list = new ArrayList<>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_QUESTION_QUERY);

			while (resultSet.next()) {
				list.add(resultSetToQuestion(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return list;
	}

	private Question resultSetToQuestion(ResultSet resultSet)throws SQLException {
		Question question = new Question(resultSet.getInt("id"), resultSet.getString("enonce"), resultSet.getString("media"), resultSet.getInt("points"), null);        
        return question;
	}

	@Override
	public Question save(Integer id, Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question delete(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

}
