package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class QuestionTirage {

	private Integer numOrdre;
	private boolean marquee;

	private Question question;
	private List<Integer> reponsesTirage = new ArrayList<Integer>();

	/**
	 * Constructeur
	 */
	public QuestionTirage() {}

	/**
	 * Constructeur BO
	 * @param numOrdre
	 * @param question
	 */
	public QuestionTirage(Integer numOrdre, Question question) {
		this.numOrdre = numOrdre;
		this.question = question;
	}

	/**
	 * Constructeur BDD
	 * @param numOrdre
	 * @param question
	 * @param marquee
	 */
	public QuestionTirage(Integer numOrdre, Question question, boolean marquee, List<Integer> reponsesTirage) {
		this.numOrdre = numOrdre;
		this.question = question;
		this.marquee = marquee;
		this.reponsesTirage = reponsesTirage;
	}

	public Integer getNumOrdre() { return this.numOrdre; }
	public boolean isMarquee() { return marquee; }
	public Question getQuestion() { return question; }
	public List<Integer> getReponsesTirage() { return reponsesTirage; }

	public void setNumOrdre(Integer numOrdre) { this.numOrdre = numOrdre; }
	public void setMarquee(boolean marquee) { this.marquee = marquee; }
	public void setQuestion(Question question) { this.question = question; }
	public void setReponsesTirage(List<Integer> reponsesTirage) { this.reponsesTirage = reponsesTirage; }

}
