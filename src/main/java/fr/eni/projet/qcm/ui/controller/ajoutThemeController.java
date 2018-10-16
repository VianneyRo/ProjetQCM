package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class ajoutThemeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ThemesManager themesManager = ManagerFactory.themesManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/jsp/collaborateur/ajouterTheme.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Theme theme = new Theme();
		String libelleTheme = req.getParameter("libelle");
		theme.setLibelle(libelleTheme);
		try {
			themesManager.ajouterTheme(theme);
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/jsp/collaborateur/gestionThemes.jsp").forward(req, resp);
	}

}
