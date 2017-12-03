package ar.edu.tis.sga.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "materia_carrera")
public class MateriaCarrera implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	@OneToOne
	@JoinColumn(name = "materia_id")
	private Materia materia;

	private Integer semestre;

	@OneToMany(mappedBy = "materiaCarrera")
	private List<ExamenFinal> examenesFinales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public List<ExamenFinal> getExamenesFinales() {
		return examenesFinales;
	}

	public void setExamenesFinales(List<ExamenFinal> examenesFinales) {
		this.examenesFinales = examenesFinales;
	}

}
