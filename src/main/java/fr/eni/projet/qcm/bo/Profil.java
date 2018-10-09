package fr.eni.projet.qcm.bo;


public class Profil {
	
	private Integer id;
	private String libelle;	
	
	/**
	 * Constructeur
	 * @param id
	 * @param libelle
	 */
	public Profil(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * Constructeur
	 * @param libelle
	 */
	public Profil(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructeur
	 */
	public Profil() {}

	public Integer getId() { return id; }
	public String getLibelle() { return libelle; }

	public void setId(Integer id) { this.id = id; }
	public void setLibelle(String libelle) { this.libelle = libelle; }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profil [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

}
