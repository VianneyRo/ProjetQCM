package fr.eni.projet.qcm.ui.controller.candidat;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.qcm.bll.factory.ManagerFactory;
import fr.eni.projet.qcm.bll.manager.EpreuvesManager;
import fr.eni.projet.qcm.bo.Epreuve;
import fr.eni.projet.qcm.bo.model.EpreuveModel;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class ConnexionController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286738201204346510L;
		EpreuvesManager epreuvesManager = ManagerFactory.epreuvesManager();

	public ConnexionController() {}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String utilisateurId = req.getAttribute("utilisateurId").toString();
		List<Epreuve> epreuves = new ArrayList<Epreuve>();
		List<EpreuveModel> epreuveModeles = new ArrayList<EpreuveModel>();
		try {
			epreuves.addAll(epreuvesManager.getEpreuvesByCandidatId(Integer.parseInt(utilisateurId)));
		} catch (NumberFormatException e) {
			req.getRequestDispatcher("/connexion").forward(req, resp);
		} catch (ManagerException e) {
			req.getRequestDispatcher("/connexion").forward(req, resp);
		}
		for(Epreuve epreuve: epreuves) {
			Date dateFin = epreuve.getDateFinValidite();
			Date dateDebut = epreuve.getDateDebutValidite();
			if(dateFin != null) {
				if(dateFin.getTime() > new Date().getTime()
				&& dateDebut.getTime() < new Date().getTime()) {
					epreuveModeles.add(new EpreuveModel(epreuve));
				}
			} else {
				epreuveModeles.add(new EpreuveModel(epreuve));
			}
		}
		req.setAttribute("epreuves", epreuveModeles.toArray());
		req.getRequestDispatcher("/candidat/accueil").forward(req, resp);
	}
}
