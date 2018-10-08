package fr.eni.projet.qcm.bo;

import java.util.List;

public class Promotion {
	
	private Integer id;
	private String libelle;
	private List<Candidat> candidats;
	
	/**
	 * @param id
	 * @param libelle
	 * @param candidats
	 */
	public Promotion(Integer id, String libelle, List<Candidat> candidats) {
		this.id = id;
		this.libelle = libelle;
		this.candidats = candidats;
	}

	/**
	 * @param libelle
	 * @param candidats
	 */
	public Promotion(String libelle, List<Candidat> candidats) {
		this.libelle = libelle;
		this.candidats = candidats;
	}

	public Integer getId() { return id; }
	public String getLibelle() { return libelle; }
	public List<Candidat> getCandidats() { return candidats; }

	public void setId(Integer id) { this.id = id; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public void setCandidats(List<Candidat> candidats) { this.candidats = candidats; }

	public void ajouterCandidat(Candidat candidat) {
		this.candidats.add(candidat);
	}

	public void supprimerCandidat(Candidat candidat) {
		this.candidats.remove(candidat);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", candidats=");
		builder.append(candidats);
		builder.append("]");
		return builder.toString();
	}

}
