package fr.eni.projet.qcm.bo.model;

import java.text.SimpleDateFormat;
import fr.eni.projet.qcm.bo.Epreuve;

public class EpreuveModel {
	private String libelle;
	private String duree;
	private String dateDebut;

	public EpreuveModel(Epreuve epreuve) {
		this.libelle = epreuve.getTest().getLibelle();
		this.dateDebut = new SimpleDateFormat("dd/MM/yy kk:mm").format(epreuve.getDateDebutValidite());

		StringBuilder sbDuree = new StringBuilder();
		int duree = epreuve.getTest().getDuree();
		if(duree / 60 > 0) {
			sbDuree.append(String.valueOf(duree / 60) + "h");
		}
		String minutes = String.valueOf(duree % 60);
		sbDuree.append(minutes.length() == 2 ? minutes : "0" + minutes);
		this.duree = sbDuree.toString();
	}

	public String getLibelle() { return this.libelle; }
	public String getDuree() { return this.duree; }
	public String getDateDebut() { return this.dateDebut; }
}