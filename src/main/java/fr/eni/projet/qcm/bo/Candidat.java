package fr.eni.projet.qcm.bo;


public class Candidat extends Utilisateur {

	/**
	 * Constructeur
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Candidat(Integer id, String nom, String prenom,
			String email, String password, Profil profil) {
		super(id, nom, prenom, email, password, profil);
	}

	/**
	 * Constructeur
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Candidat(String nom, String prenom, String email,String password, Profil profil) {
		super(nom, prenom, email, password, profil);
	}

	/**
	 * Constructeur
	 */
	public Candidat() {}

}
