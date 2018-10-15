package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.Test;
import fr.eni.projet.qcm.bo.Candidat;

@WebServlet("/CandidatController")
public class CandidatController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private  EpreuvesManager epreuvesManager = ManagerFactory.epreuvesManager();

	/* CHARGEMENT LISTES des Test */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String candidatId = req.getParameter("candidatId");
			List<Epreuve> epreuves = epreuvesManager.getEpreuvesByCandidatId(Integer.parseInt(candidatId));

			req.setAttribute("epreuves", epreuves.toArray());
			req.getRequestDispatcher("AccueilCandidat").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

}
