package fr.eni.projet.qcm.ui.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

@WebServlet("/ConnexionController")
public class ConnexionController extends HttpServlet{
	private UtilisateursManager utilisateursManager;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;

	public ConnexionController() {
		utilisateursManager = ManagerFactory.utilisateursManager();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");		
		Utilisateur utilisateur = null;
		try {
			ValidationUtil.checkNotNull(email);
			ValidationUtil.checkNotNull(password);
			utilisateur = utilisateursManager.connexion(email, password);

			if(utilisateur != null) {
				System.out.println(utilisateur.getPrenom() + " " + utilisateur.getNom());
				req.setAttribute("utilisateurId", utilisateur.getId());
				req.getRequestDispatcher("/" + utilisateur.getProfil() + "/accueil").forward(req, resp);
			} else {
				req.getRequestDispatcher("/connexion").forward(req, resp);
			}
		} catch (ManagerException e) {
			req.getRequestDispatcher("/connexion").forward(req, resp);
		}
	}

}
