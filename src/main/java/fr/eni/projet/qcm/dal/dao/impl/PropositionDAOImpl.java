package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.dal.dao.PropositionDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class PropositionDAOImpl implements PropositionDAO{
	
	private static final String INSERT_PROPOSITION_QUERY = "INSERT INTO proposition(enonce, correcte) VALUES(?,?) ";
	private static final String DELETE_PROPOSITION_QUERY = "DELETE FROM proposition WHERE id = ? ";
	private static final String UPDATE_PROPOSITION_QUERY = "UPDATE proposition SET enonce = ?, correcte = ? WHERE id = ?";

	private static PropositionDAOImpl instance;
	
	private PropositionDAOImpl(){
		
	}
	
	public static PropositionDAOImpl getInstance(){
		if (instance == null) {
			instance = new PropositionDAOImpl();
		}
		return instance;
	}

	@Override
	public Proposition insert(Proposition proposition) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_PROPOSITION_QUERY, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, proposition.getEnonce());
			statement.setBoolean(2, proposition.isCorrecte());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					proposition.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return proposition;
	}

	@Override
	public void update(Proposition proposition) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_PROPOSITION_QUERY);

			statement.setString(1, proposition.getEnonce());
			statement.setBoolean(2, proposition.isCorrecte());
			statement.setInt(2, proposition.getId());

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

			statement = connection.prepareStatement(DELETE_PROPOSITION_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		
	}

	/**
	 * Not use
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	@Override
	public Proposition selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not use
	 * @return
	 * @throws DaoException
	 */
	@Override
	public List<Proposition> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition save(Question question, Proposition proposition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposition delete(Proposition proposition) {
		// TODO Auto-generated method stub
		return null;
	}

}
