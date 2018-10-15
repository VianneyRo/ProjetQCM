package fr.eni.projet.qcm.dal.dao;

import java.util.List;

import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface EpreuveDAO {

	public List<Epreuve> selectAll() throws DaoException;
	public List<Epreuve> selectByCandidatId(Integer candidatId) throws DaoException;
	public Epreuve selectById(Integer id) throws DaoException;

	public Epreuve insert(Epreuve epreuve) throws DaoException;
	public void delete(Integer id) throws DaoException;
	public void update(Integer id, Epreuve epreuve) throws DaoException;

}
