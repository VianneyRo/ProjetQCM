package fr.eni.projet.qcm.ui.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Utilisateur;


public class CollaborateurController extends HttpServlet {
	
	private static final long serialVersionUID = 3263229810023667329L;
	private  UtilisateursManager utilisateursManager = ManagerFactory.utilisateursManager();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Utilisateur> collaborateurs= utilisateursManager.getAllCollaborateurs();
			req.setAttribute("collaborateurs", collaborateurs);
			req.getRequestDispatcher("/WEB-INF/jsp/admin/gestionCollaborateurs.jsp").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
		
	}
	
}
