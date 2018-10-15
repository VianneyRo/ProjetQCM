package fr.eni.projet.qcm.bll.manager.impl;

import java.util.List;

import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.dal.dao.EpreuveDAO;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class EpreuvesManagerImpl implements EpreuvesManager {
	private EpreuveDAO epreuveDao = DAOFactory.epreuveDao();
	private static EpreuvesManagerImpl instance;

	public static EpreuvesManagerImpl getInstance() {
		if(instance == null) {
			instance = new EpreuvesManagerImpl();
		}
		return instance;
	}

	@Override
	public List<Epreuve> getAllEpreuves() throws ManagerException {
		List<Epreuve> epreuves = null;
		try {
			epreuves = epreuveDao.selectAll();
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return epreuves;
	}

	@Override
	public List<Epreuve> getEpreuvesByCandidat(Candidat candidat) throws ManagerException {
		List<Epreuve> epreuves = null;
		try {
			epreuves = epreuveDao.selectByCandidatId(candidat.getId());
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return epreuves;
	}

	@Override
	public List<Epreuve> getEpreuvesByCandidatId(Integer candidatId) throws ManagerException {
		List<Epreuve> epreuves = null;
		try {
			epreuves = epreuveDao.selectByCandidatId(candidatId);
		} catch(Exception e) {
			throw new ManagerException(e.getMessage(), e);
		}
		return epreuves;
	}

	@Override
	public Epreuve getEpreuveById(Integer id) throws ManagerException, ElementNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterEpreuve(Candidat candidat, Test test) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEpreuve(Epreuve epreuve) throws ManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Epreuve modifierEpreuve(Epreuve theme) throws ManagerException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
