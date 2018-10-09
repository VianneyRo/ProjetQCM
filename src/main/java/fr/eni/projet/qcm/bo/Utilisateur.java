package fr.eni.projet.qcm.bo;

import fr.eni.projet.qcm.bo.Profil;

public abstract class Utilisateur {

	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;

	private Profil profil;

	/**
	 * Constructeur BO
	 * @param nom
	 * @param prenom
	 */
	public Utilisateur(String nom, String prenom, Profil profil) {
		this.nom = nom;
		this.prenom = prenom;
		this.profil = profil;
	}
	
	public Utilisateur(){
		
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
	public Utilisateur(Integer id, String nom, String prenom, String email,
			String password, Profil profil) {
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
	public Profil getProfil() { return this.profil; }

	public void setId(Integer id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setProfil(Profil profil) { this.profil = profil; }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
