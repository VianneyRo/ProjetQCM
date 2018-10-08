package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private int id;
	private String enonce;
	private String media;
	private int points;
	private List<Proposition> propositions = new ArrayList<Proposition>();

	public Question() {}

	public int getId() { return id; }
	public String getEnonce() { return enonce; }
	public String getMedia() { return media; }
	public int getPoints() { return points; }
	public List<Proposition> getPropositions() { return this.propositions; }

	public void setId(int id) { this.id = id; }
	public void setEnonce(String enonce) { this.enonce = enonce; }
	public void setMedia(String media) { this.media = media; }
	public void setPoints(int points) { this.points = points; }
	public void setPropositions(List<Proposition> propositions) { this.propositions = propositions; }

	public void ajouterProposition(Proposition proposition) {
		if(!contientProposition(proposition)) {
			this.propositions.add(proposition);
		}
	}

	public void supprimerProposition(Proposition proposition) {
		this.propositions.remove(proposition);
	}

	private boolean contientProposition(Proposition proposition) {
		for(Proposition prop: this.propositions) {
			if(prop.getEnonce().equals(proposition.getEnonce())) {
				return false;
			}
		}
		return true;
	}
}
