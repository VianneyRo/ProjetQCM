package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Theme;
import fr.eni.projet.qcm.dal.exception.DaoException;

public interface ThemeDAO {

	public List<Theme> selectAll() throws DaoException;
	public Theme selectById(Integer id) throws DaoException;

	public Theme insert(Theme theme) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Theme theme) throws DaoException;

}
