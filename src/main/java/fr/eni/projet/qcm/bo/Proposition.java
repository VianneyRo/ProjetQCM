package main.java.fr.eni.projet.qcm.bo;

public class Proposition {

	private int id;
	private String enonce;
	private boolean correcte;

	public Proposition(String enonce, boolean estBonne) {}

	public int getId() { return this.id; }
	public String getEnonce() { return this.enonce; }
	public boolean isCorrecte() { return this.correcte; }

	public void setId(int id) { this.id = id; }
	public void setEnonce(String enonce) { this.enonce = enonce; }
	public void setCorrecte(boolean correcte) { this.correcte = correcte; }
}
