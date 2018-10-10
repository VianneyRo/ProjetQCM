package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private Integer id;
	private String enonce;
	private String media;
	private Integer points;

	private List<Proposition> propositions = new ArrayList<Proposition>();

	/**
	 * Constructeur
	 */
	public Question() {}

	/**
	 * Constructeur BO
	 * @param enonce
	 * @param points
	 */
	public Question(String enonce, Integer points) {
		this.enonce = enonce;
		this.points = points;
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param enonce
	 * @param media
	 * @param points
	 * @param propositions
	 */
	public Question(Integer id, String enonce, String media, Integer points, List<Proposition> propositions) {
		this.id = id;
		this.enonce = enonce;
		this.media = media;
		this.points = points;
		this.propositions = propositions;
	}

	public Integer getId() { return id; }
	public String getEnonce() { return enonce; }
	public String getMedia() { return media; }
	public Integer getPoints() { return points; }
	public List<Proposition> getPropositions() { return this.propositions; }

	public void setId(Integer id) { this.id = id; }
	public void setEnonce(String enonce) { this.enonce = enonce; }
	public void setMedia(String media) { this.media = media; }
	public void setPoints(Integer points) { this.points = points; }
	public void setPropositions(List<Proposition> propositions) { this.propositions = propositions; }

	/**
	 * Ajoute une proposition à la question.
	 * @param proposition
	 */
	public void ajouterProposition(Proposition proposition) {
		if(!contientProposition(proposition)) {
			this.propositions.add(proposition);
		}
	}

	/**
	 * Supprime une proposition de la question.
	 * @param proposition
	 */
	public void supprimerProposition(Proposition proposition) {
		this.propositions.remove(proposition);
	}

	/**
	 * Renvoie vrai si l'énoncé de la proposition est déjà présent dans la liste des propositions.
	 * Renvoie faux sinon.
	 * @param proposition
	 * @return
	 */
	private boolean contientProposition(Proposition proposition) {
		for(Proposition prop: this.propositions) {
			if(prop.getEnonce().equals(proposition.getEnonce())) {
				return false;
			}
		}
		return true;
	}
}
