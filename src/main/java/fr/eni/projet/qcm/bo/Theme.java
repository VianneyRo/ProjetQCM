package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.qcm.bo.Question;

public class Theme {

	private Integer id;
	private String libelle;
	private List<Question> questions = new ArrayList<Question>();
	
	public Theme() {}

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

	public void ajouterQuestion(Question question) {
		this.questions.add(question);
	}

	public void supprimererQuestion(Question question) {
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
