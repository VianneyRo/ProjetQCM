package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class QuestionTirage {

	private Integer numOrdre;
	private boolean marquee;
	private Question question;
	private List<Integer> reponsesTirage = new ArrayList<Integer>();

	public QuestionTirage(int numOrdre, Question question) {
		this.numOrdre = numOrdre;
		this.question = question;
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
