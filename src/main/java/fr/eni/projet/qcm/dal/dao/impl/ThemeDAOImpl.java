package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.ThemeDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class ThemeDAOImpl implements ThemeDAO {
	
	private static final String INSERT_THEME_QUERY = "INSERT INTO theme(libelle) VALUES (?)";
	private static final String DELETE_THEME_QUERY = "DELETE FROM theme WHERE id = ?";
	private static final String UPDATE_THEME_QUERY = "UPDATE theme SET libelle = ? WHERE id = ?";
	
	private static ThemeDAOImpl instance;
	
	private ThemeDAOImpl(){
		
	}
	
	public static ThemeDAOImpl getInstance(){
		if(instance == null){
			instance = new ThemeDAOImpl();
		}
		return instance;
	}


	@Override
	public Theme insert(Theme theme) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_THEME_QUERY, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, theme.getLibelle());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					theme.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return theme;
	}

	@Override
	public void update(Theme theme) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_THEME_QUERY);

			statement.setString(1, theme.getLibelle());
			statement.setInt(2, theme.getId());

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

			statement = connection.prepareStatement(DELETE_THEME_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		
	}

	/**
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	@Override
	public Theme selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	@Override
	public List<Theme> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
