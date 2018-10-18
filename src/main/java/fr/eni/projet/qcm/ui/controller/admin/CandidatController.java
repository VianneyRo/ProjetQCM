package fr.eni.projet.qcm.ui.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.Utilisateur;

public class CandidatController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  EpreuvesManager epreuvesManager = ManagerFactory.epreuvesManager();
	private  UtilisateursManager utilisateursManager = ManagerFactory.utilisateursManager();
	
	/* CHARGEMENT LISTES des Test et des candidats*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<Utilisateur> candidats= utilisateursManager.getAllCandidats();
			req.setAttribute("candidats", candidats);
			req.getRequestDispatcher("/WEB-INF/jsp/admin/gestionCandidats.jsp").forward(req, resp);
			
//			String candidatId = req.getParameter("candidatId");
//			List<Epreuve> epreuves = epreuvesManager.getEpreuvesByCandidatId(Integer.parseInt(candidatId));
//
//			req.setAttribute("epreuves", epreuves.toArray());
//			req.getRequestDispatcher("AccueilCandidat").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

}
