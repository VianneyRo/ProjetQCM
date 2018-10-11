package fr.eni.projet.qcm.ui.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.web.common.util.ValidationUtil;

@WebServlet("/ConnexionController")
public class ConnexionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String motdepasse = req.getParameter("motdepasse");
		
		ValidationUtil.checkNotNull(email);
		ValidationUtil.checkNotNull(motdepasse);
		
		if (email.equals("admin@admin.com")){
			req.getRequestDispatcher("AdminController").forward(req, resp);
		}
		else if (email.equals("collaborateur@collaborateur.com")){
			req.getRequestDispatcher("CollaborateurController").forward(req, resp);
		}
		
		else {
			req.getRequestDispatcher("CandidatController").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String email = req.getParameter("email");
			
			if (email.equals("admin@admin.com")){
				req.getRequestDispatcher("/WEB-INF/jsp/admin/accueilAdmin.jsp").forward(req, resp);
			}
			else if (email.equals("collaborateur@collaborateur.com")){
				req.getRequestDispatcher("/WEB-INF/jsp/collaborateur/accueilCollaborateur.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/WEB-INF/jsp/candidat/accueilCandidat.jsp").forward(req, resp);
			}
		}
		catch (IllegalArgumentException f) {
			resp.sendError(400);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
	}
	
	
	
}
