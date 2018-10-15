package fr.eni.projet.qcm.bo;


public class Admin extends Utilisateur {

	/**
	 * Constructeur
	 */
	public Admin() {}

	/**
	 * Constructeur BO
	 * @param nom
	 * @param prenom
	 */
	public Admin(String nom, String prenom) {
		super(nom, prenom, "Candidat");
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public Admin(Integer id, String nom, String prenom, String email, String password) {
		super(id, nom, prenom, email, password, "Candidat");
	}
}
