package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.Proposition;
import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.ThemeDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class ThemeDAOImpl implements ThemeDAO {

	private static final String SELECT_BY_ID_QUERY = "SELECT id, libelle from theme WHERE id = ?";
	private static final String SELECT_ALL_QUERY = "SELECT id, libelle from theme";
	private static final String INSERT_THEME_QUERY = "INSERT INTO theme(libelle) VALUES (?)";
	private static final String DELETE_THEME_QUERY = "DELETE FROM theme WHERE id = ?";
	private static final String UPDATE_THEME_QUERY = "UPDATE theme SET libelle = ? WHERE id = ?";
	
	private static ThemeDAOImpl instance;
	
	private ThemeDAOImpl(){}
	
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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Theme theme = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_ID_QUERY);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				theme = resultSetToTheme(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return theme;
	}

	/**
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	@Override
	public List<Theme> selectAll() throws DaoException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Theme> themes = new ArrayList<Theme>();

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_QUERY);
			while (resultSet.next()) {
				themes.add(resultSetToTheme(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return themes;
	}

	private Theme resultSetToTheme(ResultSet resultSet) throws DaoException {
		Theme theme = null;
		try {
			theme = new Theme();
			theme.setId(resultSet.getInt("id"));
			theme.setLibelle(resultSet.getString("libelle"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return theme;
	}

}
