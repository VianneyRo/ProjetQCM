package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.TestManager;
import fr.eni.projet.qcm.bo.Test;

@WebServlet("/CandidatController")
public class CandidatController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private  TestManager testManager = ManagerFactory.testManager();

	/* CHARGEMENT LISTES des Test */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			List<Test> tests = testManager.selectAll();
			
			req.setAttribute("liste", tests);
			req.getRequestDispatcher("/WEB-INF/jsp/candidat/accueilCandidat.jsp").forward(req, resp);
			}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

}
