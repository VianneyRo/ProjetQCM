package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.dal.dao.EpreuveDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class EpreuveDAOImpl implements EpreuveDAO {
	
	private static final String SELECT_ALL_EPREUVES_QUERY = "";
	private static final String SELECT_ONE_EPREUVE_QUERY = " ";
	private static final String SELECT_ONE_EPREUVE_BY_NAME_QUERY = " ";
	private static final String INSERT_EPREUVE_QUERY = " ";
	private static final String DELETE_EPREUVE_QUERY = " ";
	private static final String UPDATE_EPREUVE_QUERY = " ";
	
	private static EpreuveDAOImpl instance;
	
	private EpreuveDAOImpl(){
		
	}
	
	public static EpreuveDAOImpl getInstance(){
		if(instance == null){
			instance = new EpreuveDAOImpl();
		}
		return instance;
	}

	@Override
	public Epreuve insert(Epreuve epreuve) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_EPREUVE_QUERY, Statement.RETURN_GENERATED_KEYS);

			statement.setDate(1, epreuve.getDateDebutValidite());
			statement.setDate(2, epreuve.getDateFinValidite());
			statement.setLong(3, epreuve.getTempsEcoule());
			statement.setString(4, epreuve.getEtat());
			statement.setFloat(5, epreuve.getNote_obtenue());
			statement.setString(6, epreuve.getNiveau_obtenu());

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					epreuve.setIdEpreuve(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return epreuve;
	}

	@Override
	public void update(Epreuve epreuve) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_EPREUVE_QUERY);

			statement.setDate(1, epreuve.getDateDebutValidite());
			statement.setDate(2, epreuve.getDateFinValidite());
			statement.setLong(3, epreuve.getTempsEcoule());
			statement.setString(4, epreuve.getEtat());
			statement.setFloat(5, epreuve.getNote_obtenue());
			statement.setString(6, epreuve.getNiveau_obtenu());
			statement.setInt(7, epreuve.getIdEpreuve());

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

			statement = connection.prepareStatement(DELETE_EPREUVE_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		
	}

	@Override
	public Epreuve selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Epreuve epreuve = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_ONE_EPREUVE_QUERY);

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				epreuve = resultSetToNote(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return epreuve;
	}

	@Override
	public List<Epreuve> selectAll() throws DaoException {
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Epreuve> list = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_EPREUVES_QUERY);

            while (resultSet.next()) {
                list.add(resultSetToNote(resultSet));
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return list;
	}

	@Override
	public boolean checkExistenceWithName(String name) throws DaoException {
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isExist = false;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_EPREUVE_BY_NAME_QUERY);
            
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            isExist = resultSet.next();
            
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return isExist;
	}
	
	private Epreuve resultSetToNote(ResultSet resultSet)throws SQLException {

		Epreuve epreuve = new Epreuve();
		// Mettre en paramètre le nom de la colonne de la table Epreuve
		epreuve.setIdEpreuve(resultSet.getInt("idEpreuve"));
		epreuve.setDateDebutValidite(resultSet.getDate("dateDebutValidite"));
		epreuve.setDateFinValidite(resultSet.getDate("dateFinValidite"));
		epreuve.setTempsEcoule(resultSet.getLong("tempsEcoule"));
		epreuve.setEtat(resultSet.getString("etat"));
		epreuve.setNote_obtenue(resultSet.getFloat("note_obtenue"));
		epreuve.setNiveau_obtenu(resultSet.getString("niveau_obtenu"));

		return epreuve;
	}

}
