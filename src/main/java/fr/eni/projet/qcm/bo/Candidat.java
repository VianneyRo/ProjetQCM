package fr.eni.projet.qcm.bo;


public class Candidat extends Utilisateur {

	/**
	 * Constructeur
	 */
	public Candidat() {}

	/**
	 * Constructeur BO
	 * @param nom
	 * @param prenom
	 */
	public Candidat(String nom, String prenom) {
		super(nom, prenom, "CAND");
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public Candidat(Integer id, String nom, String prenom, String email, String password) {
		super(id, nom, prenom, email, password, "CAND");
	}

}
