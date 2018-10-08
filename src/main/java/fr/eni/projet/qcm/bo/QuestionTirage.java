package main.java.fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class QuestionTirage {

	private int numOrdre;
	private boolean marquee;
	private Question question;
	private List<ReponseTirage> reponsesTirage = new ArrayList<ReponseTirage>();

	public QuestionTirage(int numOrdre, Question question) {
		this.numOrdre = numOrdre;
		this.question = question;
	}

	public int getNumOrdre() { return this.numOrdre; }
	public boolean isMarquee() { return marquee; }
	public Question getQuestion() { return question; }
	public List<ReponseTirage> getReponsesTirage() { return reponsesTirage; }

	public void setNumOrdre(int numOrdre) { this.numOrdre = numOrdre; }
	public void setMarquee(boolean marquee) { this.marquee = marquee; }
	public void setQuestion(Question question) { this.question = question; }
	public void setReponsesTirage(List<ReponseTirage> reponsesTirage) { this.reponsesTirage = reponsesTirage; }
	
	
}
