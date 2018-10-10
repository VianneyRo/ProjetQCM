package fr.eni.projet.qcm.ui.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tp.web.common.HttpStatus;
import fr.eni.tp.web.common.util.ValidationUtil;

public class ConnexionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
	
	public ConnexionController(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setStatus(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String motdepasse = req.getParameter("motdepasse");
		
		ValidationUtil.checkNotNull(email);
		ValidationUtil.checkNotNull(motdepasse);
		
		if (email.equals("toto@toto.fr")){
			req.getRequestDispatcher("/accueilCandidat").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/accueilCollaborateur").forward(req, resp);
		}
	}

	
}
