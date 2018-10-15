package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.projet.qcm.bo.Theme;

@WebServlet("/ThemeController")
public class ThemeController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3263229810023667329L;
	private  ThemesManager themesManager = ManagerFactory.themesManager();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Theme> themes = themesManager.getAllThemes();
			req.setAttribute("themes", themes);
			req.getRequestDispatcher("/WEB-INF/jsp/collaborateur/gestionThemes.jsp").forward(req, resp);
		}
		catch (Exception e) {
			resp.sendError(500);
		}
		
}
	}
