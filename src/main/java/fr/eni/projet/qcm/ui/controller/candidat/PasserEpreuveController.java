package fr.eni.projet.qcm.ui.controller.candidat;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.QuestionTirage;
import fr.eni.projet.qcm.bo.model.EpreuveModel;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class PasserEpreuveController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
		EpreuvesManager epreuvesManager = ManagerFactory.epreuvesManager();

	public PasserEpreuveController() {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int epreuveId = Integer.parseInt(req.getAttribute("epreuveId").toString());
		int currentQuestionNum = req.getAttribute("currentQuestionNum").toString() == null
			? Integer.parseInt(req.getAttribute("currentQuestionNum").toString())
			: 1;

		try {
			List<QuestionTirage> questionsTirage = epreuvesManager.getQuestionsByEpreuveId(epreuveId);
			QuestionTirage currentQuestion = null;
			for(QuestionTirage questionTirage: questionsTirage) {
				if(questionTirage.getNumOrdre() == currentQuestionNum);
			}
			req.setAttribute("epreuveId", epreuveId);
			req.setAttribute("currentQuestionNum", currentQuestionNum);
			req.setAttribute("currentQuestion", currentQuestion);
			req.getRequestDispatcher("/candidat/passerEpreuve").forward(req, resp);
		} catch (ManagerException e) {
		}
	}
}
