package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;

public class Theme {

	private Integer id;
	private String libelle;

	private List<Question> questions = new ArrayList<Question>();

	/**
	 * Constructeur
	 */
	public Theme() {}

	/**
	 * Constructeur BO
	 * @param libelle
	 */
	public Theme(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param libelle
	 * @param questions
	 */
	public Theme(Integer id, String libelle, List<Question> questions) {
		this.id = id;
		this.libelle = libelle;
		this.questions = questions;
	}

	public Integer getId() { return this.id; }
	public String getLibelle() { return this.libelle; }
	public List<Question> getQuestions() { return this.questions; }

	public void setId(Integer id) { this.id = id; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public void setQuestions(List<Question> questions) { this.questions = questions; }

	/**
	 * Ajoute une question à la liste des questions du thème.
	 * @param question
	 */
	public void ajouterQuestion(Question question) {
		this.questions.add(question);
	}

	/**
	 * Retire une question de la liste des questions du thème.
	 * @param question
	 */
	public void supprimerQuestion(Question question) {
		this.questions.remove(question);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theme [idTheme=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

}
