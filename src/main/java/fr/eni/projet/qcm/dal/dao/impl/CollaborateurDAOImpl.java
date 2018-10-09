package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.dal.dao.CollaborateurDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class CollaborateurDAOImpl implements CollaborateurDAO {

	private static final String SELECT_ALL_COLLABORATEURS_QUERY = "SELECT u.nom, u.prenom, u.email, u.password FROM utilisateur u WHERE u.profil_id = ?  ORDER BY n.nom DESC";
	private static final String SELECT_ONE_COLLABORATEUR_QUERY = "SELECT u.id, u.nom, u.prenom, u.email, u.password FROM utilisateur u WHERE u.id = ?";
	private static final String SELECT_ONE_COLLABORATEUR_BY_NAME_QUERY = "SELECT u.id FROM utilisateur u WHERE u.profil_id = ? AND u.nom = ?";
	private static final String INSERT_COLLABORATEUR_QUERY = "INSERT INTO utilisateur(nom, prenom, email, password, u.profil_id) VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_COLLABORATEUR_QUERY = "DELETE FROM utilisateur WHERE id = ?";
	private static final String UPDATE_COLLABORATEUR_QUERY = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, password = ? WHERE id = ?";
	
	private static final String PROFIL_ID_COLLABORATEUR = "1";
	
	private static CollaborateurDAOImpl instance;
	
	private CollaborateurDAOImpl(){
		
	}
	
	public static CollaborateurDAOImpl getInstance(){
		if (instance == null) {
			instance = new CollaborateurDAOImpl();
		}
		return instance;
	}

	@Override
	public Collaborateur insert(Collaborateur collaborateur) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(INSERT_COLLABORATEUR_QUERY, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, collaborateur.getNom());
			statement.setString(2, collaborateur.getPrenom());
			statement.setString(3, collaborateur.getEmail());
			statement.setString(4, collaborateur.getPassword());
			statement.setString(5, PROFIL_ID_COLLABORATEUR);

			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {

					collaborateur.setId(resultSet.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return collaborateur;
	}

	@Override
	public void update(Collaborateur collaborateur) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();

			statement = connection.prepareStatement(UPDATE_COLLABORATEUR_QUERY);

			statement.setString(1, collaborateur.getNom());
			statement.setString(2, collaborateur.getPrenom());
			statement.setString(3, collaborateur.getEmail());
			statement.setString(4, collaborateur.getPassword());
			statement.setInt(5, collaborateur.getId());

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

			statement = connection.prepareStatement(DELETE_COLLABORATEUR_QUERY);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}
		
	}

	@Override
	public Collaborateur selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Collaborateur collaborateur = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_ONE_COLLABORATEUR_QUERY);

			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				collaborateur = resultSetToNote(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return collaborateur;
	}

	@Override
	public List<Collaborateur> selectAll() throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Collaborateur> list = new ArrayList<>();
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ALL_COLLABORATEURS_QUERY);
            
            statement.setString(1, PROFIL_ID_COLLABORATEUR);
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

	@Override
	public boolean checkExistenceWithName(String name) throws DaoException {
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean isExist = false;
        
        try {
            connection = MSSQLConnectionFactory.get();
            statement = connection.prepareStatement(SELECT_ONE_COLLABORATEUR_BY_NAME_QUERY);
            
            statement.setString(1, PROFIL_ID_COLLABORATEUR);
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
	
	private Collaborateur resultSetToNote(ResultSet resultSet)throws SQLException {

		Collaborateur collaborateur = new Collaborateur();
		collaborateur.setId(resultSet.getInt("id"));
		collaborateur.setNom(resultSet.getString("nom"));
		collaborateur.setPrenom(resultSet.getString("prenom"));
		collaborateur.setEmail(resultSet.getString("email"));
		collaborateur.setPassword(resultSet.getString("password"));

		return collaborateur;
	}
	
	
}
