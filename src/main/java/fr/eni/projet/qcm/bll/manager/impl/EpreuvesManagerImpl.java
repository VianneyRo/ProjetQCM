package fr.eni.projet.qcm.bll.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.QuestionTirage;
import fr.eni.projet.qcm.bo.SectionTest;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.dal.dao.EpreuveDAO;
import fr.eni.projet.qcm.dal.dao.TestDAO;
import fr.eni.projet.qcm.dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class EpreuvesManagerImpl implements EpreuvesManager {
	private EpreuveDAO epreuveDao = DAOFactory.epreuveDao();
	private TestDAO testDao = DAOFactory.testDao();
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
//		List<Epreuve> epreuves = new ArrayList<Epreuve>();
//		try {
//			epreuves.addAll(epreuveDao.selectByCandidatId(candidatId));
//			for(Epreuve epreuve: epreuves) {
//				Test test = testDao.selectByEpreuveId(epreuve.getId());
//				epreuve.setTest(test);
//			}
//		} catch(Exception e) {
//			throw new ManagerException(e.getMessage(), e);
//		}
//		return epreuves;
		Test test1 = new Test(1, "JS", "JavaScript", 60, 70, 50, new ArrayList<SectionTest>());
		Test test2 = new Test(2, "J2E", "J2E - 1ere partie", 60, 60, 40, new ArrayList<SectionTest>());
		Test test3 = new Test(3, "J2E", "J2E - 2eme partie", 100, 80, 60, new ArrayList<SectionTest>());
		Date dateDebut = new Date();
		Date dateFin = new Date();
		dateDebut.setTime(1539864000000L);
		dateFin.setTime(1539876600000L);

		List<Epreuve> epreuves = new ArrayList<Epreuve>();
		epreuves.add(new Epreuve(1, null, test1, dateDebut, dateFin, 0L, "EA", 0, null));
		epreuves.add(new Epreuve(2, null, test2, dateDebut, dateFin, 0L, "EA", 0, null));
		epreuves.add(new Epreuve(3, null, test3, dateDebut, dateFin, 0L, "EA", 0, null));
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

	@Override
	public List<QuestionTirage> getQuestionsByEpreuve(Epreuve epreuve) {
		return null;
	}
	
}
