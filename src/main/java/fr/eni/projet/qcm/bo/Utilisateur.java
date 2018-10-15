package fr.eni.projet.qcm.bo;

import fr.eni.projet.qcm.bo.Profil;

public abstract class Utilisateur {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String profil;

	/**
	 * Constructeur
	 */
	public Utilisateur() {}

	/**
	 * Constructeur BO
	 * @param nom
	 * @param prenom
	 */
	public Utilisateur(String nom, String prenom, String profil) {
		this.nom = nom;
		this.prenom = prenom;
		this.profil = profil;
	}
	
	/**
	 * Constructeur BDD
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Utilisateur(Integer id, String nom, String prenom,
			String email, String password, String profil) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.profil = profil;
	}

	public Integer getId() { return this.id; }
	public String getNom() { return this.nom; }
	public String getPrenom() { return this.prenom; }
	public String getEmail() { return this.email; }
	public String getPassword() { return this.password; }
	public String getProfil() { return this.profil; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setProfil(String profil) { this.profil = profil; }

}
