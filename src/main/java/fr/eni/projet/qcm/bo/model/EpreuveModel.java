package fr.eni.projet.qcm.bo.model;

import java.text.SimpleDateFormat;
import fr.eni.projet.qcm.bo.Epreuve;

public class EpreuveModel {
	private int id;
	private String libelle;
	private String description;
	private String duree;
	private String dateDebut;

	public EpreuveModel(Epreuve epreuve) {
		this.id = epreuve.getId();
		this.libelle = epreuve.getTest().getLibelle();
		this.description = epreuve.getTest().getDescription();
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

	public int getId() { return this.id; }
	public String getLibelle() { return this.libelle; }
	public String getDescription() { return this.description; }
	public String getDuree() { return this.duree; }
	public String getDateDebut() { return this.dateDebut; }
}