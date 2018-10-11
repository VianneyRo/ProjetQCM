package fr.eni.projet.qcm.ui.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminController")
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = -7514528341493444351L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.getRequestDispatcher("/WEB-INF/jsp/admin/accueilAdmin.jsp").forward(req, resp);
			}
		catch (Exception e) {
			resp.sendError(500);
		}
	}

}
