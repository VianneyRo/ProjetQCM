package fr.eni.projet.qcm.bo;

public class Proposition {

	private Integer id;
	private String enonce;
	private boolean correcte;

	/**
	 * Constructeur BO
	 * @param enonce
	 * @param correcte
	 */
	public Proposition(String enonce, boolean correcte) {
		this.enonce = enonce;
		this.correcte = correcte;
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param enonce
	 * @param correcte
	 */
	public Proposition(Integer id, String enonce, boolean correcte) {
		this.id = id;
		this.enonce = enonce;
		this.correcte = correcte;
	}

	public Integer getId() { return this.id; }
	public String getEnonce() { return this.enonce; }
	public boolean isCorrecte() { return this.correcte; }

	public void setId(Integer id) { this.id = id; }
	public void setEnonce(String enonce) { this.enonce = enonce; }
	public void setCorrecte(boolean correcte) { this.correcte = correcte; }
}
