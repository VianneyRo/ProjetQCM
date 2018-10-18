package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class QuestionTirage {

	private Integer id;
	private Integer numOrdre;
	private boolean marquee;
	private Question question;

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
	public QuestionTirage(Integer id, Integer numOrdre, Question question, boolean marquee) {
		this.id = id;
		this.numOrdre = numOrdre;
		this.question = question;
		this.marquee = marquee;
	}

	public Integer getId() { return this.id; }
	public Integer getNumOrdre() { return this.numOrdre; }
	public boolean isMarquee() { return marquee; }
	public Question getQuestion() { return question; }

	public void setId(Integer id) { this.id = id; }
	public void setNumOrdre(Integer numOrdre) { this.numOrdre = numOrdre; }
	public void setMarquee(boolean marquee) { this.marquee = marquee; }
	public void setQuestion(Question question) { this.question = question; }

}
