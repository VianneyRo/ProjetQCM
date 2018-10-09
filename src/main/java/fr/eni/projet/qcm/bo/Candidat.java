package fr.eni.projet.qcm.bo;

import java.io.Serializable;
import java.util.List;


public class Candidat extends Utilisateur implements Serializable {


	private static final long serialVersionUID = -622666208109839291L;
	
	/**
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public Candidat(int id, String nom, String prenom, String email, String password) {
		super(id, nom, prenom, email, password);
	}

	public Candidat() {
		super();
	}
	
	


}
