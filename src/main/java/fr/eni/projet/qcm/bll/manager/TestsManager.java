package fr.eni.projet.qcm.bll.manager;

import java.util.List;

import fr.eni.projet.qcm.bo.SectionTest;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;


public interface TestsManager {

    List<Test> getAllTests() throws ManagerException;
    Test getTestById(Integer id) throws ManagerException, ElementNotFoundException;
    void ajouterTest(Test test) throws ManagerException;
    void modifierTest(Test test) throws ManagerException;
    void supprimerTest(Test test) throws ManagerException;
    List<SectionTest> getSectionsTest(Test test) throws ManagerException;

    void ajouterSectionTest(Test test, SectionTest sectionTest) throws ManagerException;
    void modifierSectionTest(SectionTest sectionTest) throws ManagerException;
    void supprimerSectionTest(SectionTest sectionTest) throws ManagerException;

}
