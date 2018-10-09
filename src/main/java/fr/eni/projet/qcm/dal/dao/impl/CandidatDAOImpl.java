package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.dal.dao.CandidatDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class CandidatDAOImpl implements CandidatDAO {

	private static final String SELECT_ALL_CANDIDATS_QUERY = "SELECT u.nom, u.prenom, u.email, u.password FROM utilisateur u WHERE u.profil_id = ?  ORDER BY n.nom DESC";
	private static final String SELECT_ONE_CANDIDAT_QUERY = "SELECT u.id, u.nom, u.prenom, u.email, u.password FROM utilisateur u WHERE u.id = ?";
	private static final String SELECT_ONE_CANDIDAT_BY_NAME_QUERY = "SELECT u.id FROM utilisateur u WHERE u.profil_id = ? AND u.nom = ? ";
	private static final String INSERT_CANDIDAT_QUERY = "INSERT INTO utilisateur(nom, prenom, email, password, u.profil_id) VALUES (?, ?, ?, ?, ?) ";
	private static final String DELETE_CANDIDAT_QUERY = "DELETE FROM utilisateur WHERE id = ? ";
	private static final String UPDATE_CANDIDAT_QUERY = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, password = ? WHERE id = ? ";
	
	private static final String PROFIL_ID_CANDIDAT = "2";

	private static CandidatDAOImpl instance;

	private CandidatDAOImpl() {

	}

	public static CandidatDAOImpl getInstance() {
		if (instance == null) {
			instance = new CandidatDAOImpl();
		}
		return instance;
	}

	@Override
	public Candidat insert(Candidat candidat) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_CANDIDAT_QUERY, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, candidat.getNom());
			statement.setString(2, candidat.getPrenom());
			statement.setString(3, candidat.getEmail());
			statement.setString(4, candidat.getPassword());
			statement.setString(5, PROFIL_ID_CANDIDAT);

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					candidat.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return candidat;
	}
	
	@Override
	public boolean checkExistenceWithName(String name) throws DaoException {
		
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isExist = false;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_CANDIDAT_BY_NAME_QUERY);
            
            statement.setString(1, PROFIL_ID_CANDIDAT);
            statement.setString(2, name);
            resultSet = statement.executeQuery();

            isExist = resultSet.next();
            
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e);
        } finally {
            ResourceUtil.safeClose(resultSet, statement, connection);
        }
        
        return isExist;
	}

	@Override
	public void update(Candidat candidat) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_CANDIDAT_QUERY);

			statement.setString(1, candidat.getNom());
			statement.setString(2, candidat.getPrenom());
			statement.setString(3, candidat.getEmail());
			statement.setString(4, candidat.getPassword());
			statement.setInt(5, candidat.getId());

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

			statement = connection.prepareStatement(DELETE_CANDIDAT_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	@Override
	public Candidat selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Candidat candidat = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_ONE_CANDIDAT_QUERY);

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				candidat = resultSetToNote(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return candidat;
	}

	@Override
	public List<Candidat> selectAll() throws DaoException {
		
		Connection connection = null;
		PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Candidat> list = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ALL_CANDIDATS_QUERY);
            
            statement.setString(1, PROFIL_ID_CANDIDAT);
            resultSet = statement.executeQuery();

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


	private Candidat resultSetToNote(ResultSet resultSet)throws SQLException {

		Candidat candidat = new Candidat();
		candidat.setId(resultSet.getInt("id"));
		candidat.setNom(resultSet.getString("nom"));
		candidat.setPrenom(resultSet.getString("prenom"));
		candidat.setEmail(resultSet.getString("email"));
		candidat.setPassword(resultSet.getString("password"));

		return candidat;
	}

	
}