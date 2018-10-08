package fr.eni.projet.qcm.bo;

import java.io.Serializable;

public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2512408522833222346L;
	
	private int idTest;
	private String libelle;
	private String description;
	private int duree;
	private float seuil_haut;
	private float seuil_bas;
	
	public Test() {
		super();
	}

	public Test(int idTest, String libelle, String description, int duree, float seuil_haut, float seuil_bas) {
		super();
		this.idTest = idTest;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.seuil_haut = seuil_haut;
		this.seuil_bas = seuil_bas;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getSeuil_haut() {
		return seuil_haut;
	}

	public void setSeuil_haut(float seuil_haut) {
		this.seuil_haut = seuil_haut;
	}

	public float getSeuil_bas() {
		return seuil_bas;
	}

	public void setSeuil_bas(float seuil_bas) {
		this.seuil_bas = seuil_bas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [idTest=");
		builder.append(idTest);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", duree=");
		builder.append(duree);
		builder.append(", seuil_haut=");
		builder.append(seuil_haut);
		builder.append(", seuil_bas=");
		builder.append(seuil_bas);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
