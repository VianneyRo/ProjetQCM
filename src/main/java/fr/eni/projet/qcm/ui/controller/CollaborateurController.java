package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.ThemesManager;

@WebServlet("/CollaborateurController")
public class CollaborateurController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5989375503094363132L;
	private  ThemesManager themesManager = ManagerFactory.themesManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		try {
			req.getRequestDispatcher("WEB-INF/jsp/collaborateur/accueilCollaborateur.jsp").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}
}
