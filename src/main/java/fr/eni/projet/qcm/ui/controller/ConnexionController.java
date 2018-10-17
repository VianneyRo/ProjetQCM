package fr.eni.projet.qcm.ui.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Profil;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.tp.web.common.util.ValidationUtil;

public class ConnexionController extends HttpServlet{
	private UtilisateursManager utilisateursManager;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
	
	Utilisateur utilisateur = null;
	
	public ConnexionController() {
		utilisateursManager = ManagerFactory.utilisateursManager();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Utilisateur utilisateur = null;
		Profil profil = null;

		try {
			ValidationUtil.checkNotNull(email);
			ValidationUtil.checkNotNull(password);
			utilisateur = utilisateursManager.connexion(email, password);
			if(utilisateur != null) {
				profil = utilisateursManager.selectProfilByUtilisateurId(utilisateur.getId());
				req.setAttribute("utilisateurId", utilisateur.getId());
				if(profil == null) {
					throw new Exception();
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			req.getRequestDispatcher("/connexion").forward(req, resp);
		}
		req.setAttribute("userId", utilisateur.getId());
		req.getRequestDispatcher("/" + profil.getLibelle() + "/controller").forward(req, resp);
	}

}
