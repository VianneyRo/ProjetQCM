package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.dal.dao.TestDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class TestDAOImpl implements TestDAO {

	private static final String INSERT_TEST_QUERY = "INSERT INTO test(libelle, description, duree, seuilHaut, seuilBas) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_TEST_QUERY = "DELETE FROM test WHERE id = ?";
	private static final String UPDATE_TEST_QUERY = "UPDATE test SET libelle = ?, description = ?, duree = ?, seuilHaut = ?, seuilBas = ? WHERE id = ?";
	private static final String SELECT_ALL_QUERY = "SELECT libelle FROM test";
	private static final String SELECT_BY_EPREUVE = "SELECT t.id, t.libelle, t.description, t.duree, t.seuil_haut, t.seuil_bas FROM epreuve e, test t WHERE e.id_test=t.id AND e.id=?";

	private static TestDAOImpl instance;
	
	private TestDAOImpl(){
		
	}
	
	public static TestDAOImpl getInstance(){
		if(instance == null){
			instance = new TestDAOImpl();
		}
		return instance;
	}


	@Override
	public List<Test> selectAll() throws DaoException {
		List<Test> tests = new ArrayList<Test>();
		Test test = null;
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connexion = MSSQLConnectionFactory.get();
			statement = connexion.prepareStatement(SELECT_ALL_QUERY);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				test = new Test();
				test.setLibelle(resultSet.getString("libelle"));
				test.setDescription(resultSet.getString("description"));
				test.setDuree(resultSet.getInt(4));
				tests.add(test);
			}

		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		finally {
			ResourceUtil.safeClose(resultSet, statement, connexion);
		}
		
		return tests;
	}

	@Override
	public Test selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test selectByEpreuveId(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Test test = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_EPREUVE, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				test = resultSetToTest(resultSet);
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		return test;
	}
	
	@Override
	public Test insert(Test test) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT_TEST_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, test.getLibelle());
			statement.setString(2, test.getDescription());
			statement.setInt(3, test.getDuree());
			statement.setFloat(4, test.getSeuilHaut());
			statement.setFloat(5, test.getSeuilBas());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					test.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return test;
	}

	@Override
	public void update(Integer testId, Test test) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_TEST_QUERY);

			statement.setString(1, test.getLibelle());
			statement.setString(2, test.getDescription());
			statement.setInt(3, test.getDuree());
			statement.setFloat(4, test.getSeuilHaut());
			statement.setFloat(5, test.getSeuilBas());
			statement.setInt(6, test.getId());

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

			statement = connection.prepareStatement(DELETE_TEST_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	private Test resultSetToTest(ResultSet resultSet) throws DaoException {
		Test test = new Test();
		try {
			test.setId(resultSet.getInt("id"));
			test.setLibelle(resultSet.getString("libelle"));
			test.setDescription(resultSet.getString("description"));
			test.setDuree(resultSet.getInt("duree"));
			test.setSeuilHaut(resultSet.getFloat("seuil_haut"));
			test.setSeuilBas(resultSet.getFloat("seuil_bas"));
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return test;
	}

}
