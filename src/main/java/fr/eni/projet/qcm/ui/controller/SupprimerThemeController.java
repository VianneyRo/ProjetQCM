package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.ThemesManager;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

public class SupprimerThemeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private  ThemesManager themesManager = ManagerFactory.themesManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer idTheme = Integer.parseInt(req.getParameter("idTheme"));		
		ValidationUtil.checkNotNull(idTheme);
		try {
			themesManager.supprimerTheme(idTheme);
			
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("../collaborateur/gestionThemes").forward(req, resp);
	}	
	
	
	
	

}
