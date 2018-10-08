package fr.eni.projet.qcm.bo;

public class Collaborateur extends Utilisateur {

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Collaborateur(Integer id, String nom, String prenom,
			String email, String password, Profil profil) {
		super(id, nom, prenom, email, password, profil);
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Collaborateur(String nom, String prenom, String email, String password, Profil profil) {
		super(nom, prenom, email, password, profil);
	}

}
