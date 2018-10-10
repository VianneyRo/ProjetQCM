package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SectionTest {
	
	private Integer nbQuestionsATirer;

	private Theme theme;

	/**
	 * Constructeur
	 */
	public SectionTest() {}

	/**
	 * Constructeur BO
	 * @param theme
	 */
	public SectionTest(Theme theme) {
		this.nbQuestionsATirer = 1;
		this.theme = theme;
	}

	/**
	 * Constructeur BDD
	 * @param nbQuestionsATirer
	 * @param theme
	 */
	public SectionTest(int nbQuestionsATirer, Theme theme) {
		this.nbQuestionsATirer = nbQuestionsATirer;
		this.theme = theme;
	}

	public Integer getNbQuestionsATirer() { return nbQuestionsATirer; }
	public Theme getTheme() { return theme; }

	public void setNbQuestionsATirer(int nbQuestionsATirer) { this.nbQuestionsATirer = nbQuestionsATirer; }
	public void setTheme(Theme theme) { this.theme = theme; }

	/**
	 * Renvoie une liste de questions de taille n aléatoirement choises parmi les questions du thème.
	 * @return
	 * @throws Exception
	 */
	public List<Question> tirerQuestions() throws Exception {
		List<Question> ensembleQuestions = this.theme.getQuestions();
		List<Question> questionsTirees = null;
		if(this.nbQuestionsATirer > ensembleQuestions.size()) {
			throw new Exception("Le nombre de questions à tirer est supérieur au nombre de questions disponibles");
		} else {
			Random random = new Random();
			questionsTirees = new ArrayList<Question>();
			for(int i = 0; i < this.nbQuestionsATirer; i++) {
				int randomIndex = random.nextInt(ensembleQuestions.size());
				Question questionTiree = ensembleQuestions.get(randomIndex);
				questionsTirees.add(questionTiree);
				ensembleQuestions.remove(questionTiree);
			}
		}
		return questionsTirees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Section_Test [nbQuestionsATirer=");
		builder.append(nbQuestionsATirer);
		builder.append(", idTheme=");
		builder.append(theme);
		builder.append("]");
		return builder.toString();
	}

}
