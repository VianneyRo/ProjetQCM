package fr.eni.projet.qcm.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;
import fr.eni.projet.qcm.bo.QuestionTirage;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.dao.QuestionTirageDAO;
import fr.eni.projet.qcm.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class QuestionTirageDAOImpl implements QuestionTirageDAO {
	private static final String SELECT_BY_EPREUVE = "SELECT id, id_epreuve, id_question, num, marquee FROM question_tirage WHERE id_epreuve=?";
	private static QuestionTirageDAOImpl instance;

	public static QuestionTirageDAOImpl getInstance() {
		if(instance == null) {
			instance = new QuestionTirageDAOImpl();
		}
		return instance;
	}

	@Override
	public List<QuestionTirage> selectByEpreuveId(Integer epreuveId) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<QuestionTirage> questionsTirage = new ArrayList<QuestionTirage>();
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_BY_EPREUVE);
			statement.setInt(1, epreuveId);

			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				questionsTirage.add(resultSetToQuestionTirage(resultSet));
			}
		} catch(Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
		return questionsTirage;
	}

	@Override
	public QuestionTirage selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionTirage insert(QuestionTirage question, Integer epreuveId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	private QuestionTirage resultSetToQuestionTirage(ResultSet resultSet) {
		QuestionTirage questionTirage = null;
		try {
			questionTirage = new QuestionTirage();
			questionTirage.setId(resultSet.getInt("id"));
			questionTirage.setNumOrdre(resultSet.getInt("num"));
			questionTirage.setMarquee(resultSet.getBoolean("marquee"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionTirage;
	}
}
