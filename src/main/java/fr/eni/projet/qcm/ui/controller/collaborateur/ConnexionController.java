package fr.eni.projet.qcm.ui.controller.collaborateur;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;

	public ConnexionController() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/accueil").forward(req, resp);
	}

}
