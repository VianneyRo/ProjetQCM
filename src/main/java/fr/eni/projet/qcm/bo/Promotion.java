package fr.eni.projet.qcm.bo;

import java.io.Serializable;
import java.util.List;

public class Promotion implements Serializable{

	private static final long serialVersionUID = -4053613485955939980L;
	
	private int id;
	private String libelle;
	private List<Candidat> candidats;
	
	/**
	 * 
	 * @param id
	 * @param libelle
	 * @param candidats
	 */
	public Promotion(int id, String libelle, List<Candidat> candidats) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.candidats = candidats;
	}

	/**
	 * 
	 * @param libelle
	 * @param candidats
	 */
	public Promotion(String libelle, List<Candidat> candidats) {
		super();
		this.libelle = libelle;
		this.candidats = candidats;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", candidats=");
		builder.append(candidats);
		builder.append("]");
		return builder.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}
	
	
}
