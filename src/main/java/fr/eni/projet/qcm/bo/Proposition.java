package fr.eni.projet.qcm.bo;

public class Proposition {

	private Integer id;
	private String enonce;
	private boolean correcte;

	/**
	 * @param enonce
	 * @param estBonne
	 */
	public Proposition(String enonce, boolean estBonne) {}

	public Integer getId() { return this.id; }
	public String getEnonce() { return this.enonce; }
	public boolean isCorrecte() { return this.correcte; }

	public void setId(Integer id) { this.id = id; }
	public void setEnonce(String enonce) { this.enonce = enonce; }
	public void setCorrecte(boolean correcte) { this.correcte = correcte; }
}
