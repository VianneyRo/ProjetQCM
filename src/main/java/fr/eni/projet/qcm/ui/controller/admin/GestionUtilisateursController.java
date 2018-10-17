package fr.eni.projet.qcm.ui.controller.admin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.UtilisateursManager;
import fr.eni.projet.qcm.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class GestionUtilisateursController extends HttpServlet{
	private UtilisateursManager utilisateursManager;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;

	public GestionUtilisateursController() {
		utilisateursManager = ManagerFactory.utilisateursManager();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			utilisateurs = utilisateursManager.selectAll();
		} catch (ManagerException e) {
			req.getRequestDispatcher("/admin/accueil").forward(req, resp);;
		}
		req.setAttribute("users", utilisateurs.toArray());
		req.getRequestDispatcher("/admin/utilisateurs").forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utilisateurIdParameter = req.getParameter("utilisateurId");
		if(utilisateurIdParameter != null) {
			try {
				utilisateursManager.supprimerUtilisateur(Integer.parseInt(utilisateurIdParameter));
			} catch(Exception e) {
				
			}
		}
		this.doGet(req, resp);
	}

}
