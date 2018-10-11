package fr.eni.projet.qcm.ui.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConnexionController")
public class ConnexionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String email = req.getParameter("email");
		String motdepasse = req.getParameter("motdepasse");
		
		ValidationUtil.checkNotNull(email);
		ValidationUtil.checkNotNull(motdepasse);
		
		if (email.equals("admin@admin.com")){
			req.getRequestDispatcher("/CandidatController").forward(req, resp);
		}
		else if (email.equals("collaborateur@collaborateur.com")){
			req.getRequestDispatcher("/CollaborateurController").forward(req, resp);
		}
		
		else {
			req.getRequestDispatcher("/CandidatController").forward(req, resp);
		}*/
		System.out.println("toto");
	}

	
}
