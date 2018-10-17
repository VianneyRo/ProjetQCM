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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/accueil").forward(req, resp);
	}

}
