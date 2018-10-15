package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.QuestionsManager;
import fr.eni.projet.qcm.bo.Question;

@WebServlet("/SelectionController")
public class SelectionController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7885126200275346869L;
	private  QuestionsManager questionManager = ManagerFactory.questionsManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			List<Question> lesQuestions = questionManager.selectAll();
			req.setAttribute("questions", lesQuestions);
			req.getRequestDispatcher("/WEB-INF/jsp/candidat/passageEpreuve.jsp").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}
	

}
