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
	
	public Test() {}
	public Test(Integer idTest, String libelle, String description, Integer duree,
			float seuilHaut, float seuilBas, List<SectionTest> sectionsTest) {
		super();
		this.id = idTest;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
		this.sectionsTest = sectionsTest;
	}

	public Integer getIdTest() { return id; }
	public String getLibelle() { return libelle; }
	public String getDescription() { return description; }
	public Integer getDuree() { return duree; }
	public float getSeuilHaut() { return seuilHaut; }
	public float getSeuilBas() { return seuilBas; }
	public List<SectionTest> getSectionsTest() { return this.sectionsTest; }

	public void setIdTest(Integer idTest) { this.id = idTest; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public void setDescription(String description) { this.description = description; }
	public void setDuree(Integer duree) { this.duree = duree; }
	public void setSeuilHaut(float seuilHaut) { this.seuilHaut = seuilHaut; }
	public void setSeuilBas(float seuilBas) { this.seuilBas = seuilBas; }
	public void setSectionsTest(List<SectionTest> sectionsTest) { this.sectionsTest = sectionsTest; }

	public void ajouterSectionTest(SectionTest sectionTest) {
		this.sectionsTest.add(sectionTest);
	}

	public void supprimerSectionTest(SectionTest sectionTest) {
		this.sectionsTest.remove(sectionTest);
	}

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
