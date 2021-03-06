package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bo.Theme;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

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
		if(libelleTheme == null || libelleTheme.length() == 0){
			
		}
		theme.setLibelle(libelleTheme);
		try {
			themesManager.ajouterTheme(theme);
			List<Theme> themes = themesManager.getAllThemes();
			req.setAttribute("themes", themes);
			req.getRequestDispatcher("/WEB-INF/jsp/collaborateur/gestionThemes.jsp").forward(req, resp);
		} catch (ManagerException e) {
			e.printStackTrace();
		}
	}

}
