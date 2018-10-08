package fr.eni.projet.qcm.bo;

import java.io.Serializable;

public class Profil implements Serializable {

	private static final long serialVersionUID = 8724460074293802216L;
	
	private int id;
	private String libelle;	
	
	/**
	 * 
	 * @param id
	 * @param libelle
	 */
	public Profil(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * 
	 * @param libelle
	 */
	public Profil(String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profil [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
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
	
	
	
	
}
