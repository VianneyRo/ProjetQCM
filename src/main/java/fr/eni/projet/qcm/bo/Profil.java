package fr.eni.projet.qcm.bo;


public class Profil {
	
	private Integer id;
	private String code;
	private String libelle;	

	/**
	 * Constructeur
	 */
	public Profil() {}

	/**
	 * Constructeur BO
	 * @param libelle
	 */
	public Profil(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}
	
	/**
	 * Constructeur BDD
	 * @param id
	 * @param libelle
	 */
	public Profil(Integer id, String code, String libelle) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public Integer getId() { return id; }
	public String getCode() { return code; }
	public String getLibelle() { return libelle; }

	public void setId(Integer id) { this.id = id; }
	public void setCode(String code) { this.code = code; }
	public void setLibelle(String libelle) { this.libelle = libelle; }

}
