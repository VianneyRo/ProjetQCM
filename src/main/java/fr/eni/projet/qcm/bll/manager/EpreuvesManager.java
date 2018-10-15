package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.Candidat;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.SectionTest;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;


public interface EpreuvesManager {

    List<Epreuve> getAllEpreuves() throws ManagerException;
    List<Epreuve> getEpreuvesByCandidat(Candidat candidat) throws ManagerException;
    List<Epreuve> getEpreuvesByCandidatId(Integer candidatId) throws ManagerException;
    Epreuve getEpreuveById(Integer id) throws ManagerException, ElementNotFoundException;

    void ajouterEpreuve(Candidat candidat, Test test) throws ManagerException;
    void supprimerEpreuve(Epreuve epreuve) throws ManagerException;
    Epreuve modifierEpreuve(Epreuve theme) throws ManagerException;

}
