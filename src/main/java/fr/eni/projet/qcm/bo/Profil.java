package fr.eni.projet.qcm.bo;


public class Profil {
	private String code;
	private String libelle;	

	/**
	 * Constructeur
	 */
	public Profil() {}

	/**
	 * Constructeur BO / BDD
	 * @param libelle
	 */
	public Profil(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	public String getCode() { return code; }
	public String getLibelle() { return libelle; }

	public void setCode(String code) { this.code = code; }
	public void setLibelle(String libelle) { this.libelle = libelle; }

}
