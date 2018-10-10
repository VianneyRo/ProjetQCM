package fr.eni.projet.qcm.bo;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	private Integer id;
	private String libelle;
	private String description;
	private Integer duree;
	private float seuilHaut;
	private float seuilBas;

	private List<SectionTest> sectionsTest = new ArrayList<SectionTest>();

	/**
	 * Constructeur
	 */
	public Test() {}

	/**
	 * Constructeur BO
	 */
	public Test(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Constructeur BDD
	 * @param id
	 * @param libelle
	 * @param description
	 * @param duree
	 * @param seuilHaut
	 * @param seuilBas
	 * @param sectionsTest
	 */
	public Test(Integer id, String libelle, String description, Integer duree,
			float seuilHaut, float seuilBas, List<SectionTest> sectionsTest) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
		this.sectionsTest = sectionsTest;
	}

	public Integer getId() { return id; }
	public String getLibelle() { return libelle; }
	public String getDescription() { return description; }
	public Integer getDuree() { return duree; }
	public float getSeuilHaut() { return seuilHaut; }
	public float getSeuilBas() { return seuilBas; }
	public List<SectionTest> getSectionsTest() { return this.sectionsTest; }

	public void setId(Integer id) { this.id = id; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public void setDescription(String description) { this.description = description; }
	public void setDuree(Integer duree) { this.duree = duree; }
	public void setSeuilHaut(float seuilHaut) { this.seuilHaut = seuilHaut; }
	public void setSeuilBas(float seuilBas) { this.seuilBas = seuilBas; }
	public void setSectionsTest(List<SectionTest> sectionsTest) { this.sectionsTest = sectionsTest; }

	/**
	 * Ajoute une section de test au test.
	 * @param sectionTest
	 */
	public void ajouterSectionTest(SectionTest sectionTest) {
		this.sectionsTest.add(sectionTest);
	}

	/**
	 * Retire une section de test du test.
	 * @param sectionTest
	 */
	public void supprimerSectionTest(SectionTest sectionTest) {
		this.sectionsTest.remove(sectionTest);
	}

	/**
	 * Renvoie une liste de questions tirées aléatoirement de toutes les sections de test.
	 * @return
	 * @throws Exception
	 */
	public List<Question> tirerQuestions() throws Exception {
		List<Question> questionsTirees = null;
		try {
			questionsTirees = new ArrayList<Question>();
			for(SectionTest sectionTest: this.sectionsTest) {
				questionsTirees.addAll(sectionTest.tirerQuestions());
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return questionsTirees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [idTest=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", duree=");
		builder.append(duree);
		builder.append(", seuil_haut=");
		builder.append(seuilHaut);
		builder.append(", seuil_bas=");
		builder.append(seuilBas);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
