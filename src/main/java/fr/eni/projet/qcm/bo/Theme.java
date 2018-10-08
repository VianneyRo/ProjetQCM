package fr.eni.projet.qcm.bo;

import java.io.Serializable;

public class Theme implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8015702896692045415L;
	private int idTheme;
	private String libelle;
	
	public Theme() {
		super();
	}

	public Theme(int idTheme, String libelle) {
		super();
		this.idTheme = idTheme;
		this.libelle = libelle;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theme [idTheme=");
		builder.append(idTheme);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
