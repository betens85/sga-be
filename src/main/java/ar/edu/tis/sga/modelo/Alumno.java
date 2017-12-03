package ar.edu.tis.sga.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno extends Persona {

	@OneToMany(mappedBy = "alumno")
	private List<InscripcionCarrera> inscripcionesCarrera;

	@OneToMany(mappedBy = "alumno")
	private List<InscripcionMateria> inscripcionesMateria;

	@OneToMany(mappedBy = "alumno")
	private List<ResultadoExamen> resultadosExamenes;

	public List<InscripcionCarrera> getInscripcionesCarrera() {
		return inscripcionesCarrera;
	}

	public void setInscripcionesCarrera(List<InscripcionCarrera> inscripcionesCarrera) {
		this.inscripcionesCarrera = inscripcionesCarrera;
	}

	public List<ResultadoExamen> getResultadosExamenes() {
		return resultadosExamenes;
	}

	public void setResultadosExamenes(List<ResultadoExamen> resultadosExamenes) {
		this.resultadosExamenes = resultadosExamenes;
	}

	public List<InscripcionMateria> getInscripcionesMateria() {
		return inscripcionesMateria;
	}

	public void setInscripcionesMateria(List<InscripcionMateria> inscripcionesMateria) {
		this.inscripcionesMateria = inscripcionesMateria;
	}

}
