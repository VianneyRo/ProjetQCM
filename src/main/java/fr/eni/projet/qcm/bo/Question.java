package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private Integer id;
	private String enonce;
	private String media;
	private Integer points;
	private List<Proposition> propositions = new ArrayList<Proposition>();

	public Question() {}

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
