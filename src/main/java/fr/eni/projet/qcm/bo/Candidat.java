package fr.eni.projet.qcm.bo;


public class Candidat extends Utilisateur {

	/**
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
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param profil
	 */
	public Candidat(String nom, String prenom, String email,String password, Profil profil) {
		super(nom, prenom, email, password, profil);
	}

}
