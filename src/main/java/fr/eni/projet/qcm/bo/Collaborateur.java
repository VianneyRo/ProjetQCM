package fr.eni.projet.qcm.bo;

import java.io.Serializable;

public class Collaborateur extends Utilisateur implements Serializable {

	private static final long serialVersionUID = -6683587888031135573L;
	
	public Collaborateur(){
		
	}

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 */
	public Collaborateur(String nom, String prenom, String email, String password) {
		super(nom, prenom, email, password);
	}

}
