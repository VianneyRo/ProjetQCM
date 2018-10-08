package fr.eni.projet.qcm.bo;

import java.io.Serializable;

public class Section_Test implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7957509632981530506L;
	
	private int nbQuestionsATirer;
	private int idTheme;
	private int idTest;
	
	public Section_Test() {
		super();
	}

	public Section_Test(int nbQuestionsATirer) {
		super();
		this.nbQuestionsATirer = nbQuestionsATirer;
	}

	public Section_Test(int nbQuestionsATirer, int idTheme, int idTest) {
		super();
		this.nbQuestionsATirer = nbQuestionsATirer;
		this.idTheme = idTheme;
		this.idTest = idTest;
	}

	public int getNbQuestionsATirer() {
		return nbQuestionsATirer;
	}

	public void setNbQuestionsATirer(int nbQuestionsATirer) {
		this.nbQuestionsATirer = nbQuestionsATirer;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Section_Test [nbQuestionsATirer=");
		builder.append(nbQuestionsATirer);
		builder.append(", idTheme=");
		builder.append(idTheme);
		builder.append(", idTest=");
		builder.append(idTest);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
