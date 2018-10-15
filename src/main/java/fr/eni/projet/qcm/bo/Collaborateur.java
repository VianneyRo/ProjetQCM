package fr.eni.projet.qcm.bo;

public class Collaborateur extends Utilisateur {

	/**
	 * Constructeur
	 */
	public Collaborateur() {}

	/**
	 * Constructeur BO
	 * @param nom
	 * @param prenom
	 */
	public Collaborateur(String nom, String prenom) {
		super(nom, prenom, "Collaborateur");
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
	public Collaborateur(Integer id, String nom, String prenom, String email, String password) {
		super(id, nom, prenom, email, password, "Collaborateur");
	}

}
