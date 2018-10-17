package fr.eni.projet.qcm.bo;


public class Candidat extends Utilisateur {
	private String codePromotion;

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
	public Candidat(Integer id, String nom, String prenom, String email, String password, String codePromotion) {
		super(id, nom, prenom, email, password, "CAND");
		this.codePromotion = codePromotion;
	}

	public String getCodePromotion() { return this.codePromotion; }
	public void setCodePromotion(String codePromotion) { this.codePromotion = codePromotion; }
}
