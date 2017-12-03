package ar.edu.tis.sga.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultado_examen")
public class ResultadoExamen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;

	@OneToOne
	@JoinColumn(name = "resultado_id")
	private Resultado resultado;

	@OneToOne
	@JoinColumn(name = "inscripcion_examen_id")
	private InscripcionExamen inscripcion;

	public InscripcionExamen getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(InscripcionExamen inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
