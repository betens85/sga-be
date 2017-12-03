package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class Docente extends Persona {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id")
	private Archivo curriculumVitae;

	public Archivo getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(Archivo curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

}
