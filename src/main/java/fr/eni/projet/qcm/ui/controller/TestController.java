package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.TestsManager;
import fr.eni.projet.qcm.bo.Test;

@WebServlet("/TestController")
public class TestController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2214232883972441639L;
	private  TestsManager testsManager = ManagerFactory.testsManager();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Test> tests= testsManager.getAllTests();
			req.setAttribute("tests", tests);
			req.getRequestDispatcher("/WEB-INF/jsp/candidat/accueil.jsp").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
		
	}

}
