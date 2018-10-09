package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Epreuve {
	
	private Integer id;
	private Date dateDebutValidite;
	private Date dateFinValidite;
	private long tempsEcoule;
	private float noteObtenue;
	private String niveauObtenu;
	private String etat;

	private Candidat candidat;
	private Test test;
	private List<QuestionTirage> questionsTirage = new ArrayList<QuestionTirage>();
	
	/**
	 * Constructeur BO
	 * @param candidat
	 * @param test
	 */
	public Epreuve(Candidat candidat, Test test) {
		this.candidat = candidat;
		this.test = test;
	}

	/**
	 * Constructeur BDD
	 * @param candidat
	 * @param test
	 * @param dateDebutValidite
	 * @param dateFinValidite
	 * @param tempsEcoule
	 * @param etat
	 * @param noteObtenue
	 * @param niveauObtenu
	 */
	public Epreuve(Integer id, Candidat candidat, Test test, Date dateDebutValidite,
			Date dateFinValidite, long tempsEcoule, String etat, float noteObtenue,
			String niveauObtenu) {
		this.id = id;
		this.candidat = candidat;
		this.test = test;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.noteObtenue = noteObtenue;
		this.niveauObtenu = niveauObtenu;
	}

	public Integer getId() { return id; }
	public Date getDateDebutValidite() { return dateDebutValidite; }
	public Date getDateFinValidite() { return dateFinValidite; }
	public long getTempsEcoule() { return tempsEcoule; }
	public float getNoteObtenue() { return noteObtenue; }
	public String getNiveauObtenu() { return niveauObtenu; }
	public String getEtat() { return etat; }
	public Candidat getCandidat() { return candidat; }
	public Test getTest() { return test; }
	public List<QuestionTirage> getQuestionsTirage() { return this.questionsTirage; }

	public void setId(Integer id) { this.id = id; }
	public void setDateDebutValidite(Date dateDebutValidite) { this.dateDebutValidite = dateDebutValidite; }
	public void setDateFinValidite(Date dateFinValidite) { this.dateFinValidite = dateFinValidite; }
	public void setTempsEcoule(long tempsEcoule) { this.tempsEcoule = tempsEcoule; }
	public void setNote_obtenue(float note_obtenue) { this.noteObtenue = note_obtenue; }
	public void setNiveau_obtenu(String niveau_obtenu) { this.niveauObtenu = niveau_obtenu; }
	public void setEtat(String etat) { this.etat = etat; }
	public void setCandidat(Candidat candidat) { this.candidat = candidat; }
	public void setTest(Test test) { this.test = test; }
	public void setQuestionsTirage(List<QuestionTirage> questionsTirage) { this.questionsTirage = questionsTirage; }

	/**
	 * Génère les questionsTirage d'une épreuve à partir des questions du test.
	 * @throws Exception
	 */
	public void tirerQuestions() throws Exception {
		List<Question> questions = null;
		try {
			questions = this.test.tirerQuestions();

			int index = 0;
			this.questionsTirage = new ArrayList<QuestionTirage>();
			for(Question question: questions) {
				this.questionsTirage.add(new QuestionTirage(index++, question));
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Epreuve [idEpreuve=");
		builder.append(id);
		builder.append(", dateDebutValidite=");
		builder.append(dateDebutValidite);
		builder.append(", dateFinValidite=");
		builder.append(dateFinValidite);
		builder.append(", tempsEcoule=");
		builder.append(tempsEcoule);
		builder.append(", etat=");
		builder.append(etat);
		builder.append(", note_obtenue=");
		builder.append(noteObtenue);
		builder.append(", niveau_obtenu=");
		builder.append(niveauObtenu);
		builder.append("]");
		return builder.toString();
	}


	
	
}
