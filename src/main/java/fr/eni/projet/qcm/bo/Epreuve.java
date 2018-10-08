package fr.eni.projet.qcm.bo;

import java.io.Serializable;
import java.util.Date;

public class Epreuve implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -404541744556399989L;
	
	private int idEpreuve;
	private Date dateDebutValidite;
	private Date dateFinValidite;
	private long tempsEcoule;
	private String etat;
	private float note_obtenue;
	private String niveau_obtenu;
	
	
	public Epreuve() {
		super();
	}


	public Epreuve(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, long tempsEcoule, String etat,
			float note_obtenue, String niveau_obtenu) {
		super();
		this.idEpreuve = idEpreuve;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.note_obtenue = note_obtenue;
		this.niveau_obtenu = niveau_obtenu;
	}


	public int getIdEpreuve() {
		return idEpreuve;
	}


	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}


	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}


	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}


	public Date getDateFinValidite() {
		return dateFinValidite;
	}


	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}


	public long getTempsEcoule() {
		return tempsEcoule;
	}


	public void setTempsEcoule(long tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public float getNote_obtenue() {
		return note_obtenue;
	}


	public void setNote_obtenue(float note_obtenue) {
		this.note_obtenue = note_obtenue;
	}


	public String getNiveau_obtenu() {
		return niveau_obtenu;
	}


	public void setNiveau_obtenu(String niveau_obtenu) {
		this.niveau_obtenu = niveau_obtenu;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Epreuve [idEpreuve=");
		builder.append(idEpreuve);
		builder.append(", dateDebutValidite=");
		builder.append(dateDebutValidite);
		builder.append(", dateFinValidite=");
		builder.append(dateFinValidite);
		builder.append(", tempsEcoule=");
		builder.append(tempsEcoule);
		builder.append(", etat=");
		builder.append(etat);
		builder.append(", note_obtenue=");
		builder.append(note_obtenue);
		builder.append(", niveau_obtenu=");
		builder.append(niveau_obtenu);
		builder.append("]");
		return builder.toString();
	}


	
	
}
