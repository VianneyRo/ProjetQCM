package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Collaborateur;
import fr.eni.projet.qcm.bo.Utilisateur;


@WebServlet("/ajoutCollaborateurController")
public class ajoutCollaborateurController extends HttpServlet{
	
	private static final long serialVersionUID = 2428998334907781285L;
	private  UtilisateursManager utilisateursManager = ManagerFactory.utilisateursManager();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
			req.getRequestDispatcher("/WEB-INF/jsp/admin/ajoutCollaborateurs.jsp").forward(req, resp);
		
}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Utilisateur unCollaborateur = new Collaborateur();
		
		try {
			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");
			String email = req.getParameter("email");
			
			unCollaborateur.setNom(nom);
			unCollaborateur.setPrenom(prenom);
			unCollaborateur.setEmail(email);
			utilisateursManager.insert(unCollaborateur);
			
			List<Utilisateur> collaborateurs= utilisateursManager.getAllCollaborateurs();
			req.setAttribute("collaborateurs", collaborateurs);
			req.getRequestDispatcher("/WEB-INF/jsp/admin/gestionCollaborateurs.jsp").forward(req, resp);
		} catch (Exception e) {
				resp.sendError(500);
		}
	}
}
