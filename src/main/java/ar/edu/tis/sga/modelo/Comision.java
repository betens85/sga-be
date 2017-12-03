package ar.edu.tis.sga.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "comision")
public class Comision implements Serializable {

	private static final long serialVersionUID = 4414656729606101541L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_carrera_id")
	private MateriaCarrera materiaCarrera;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "docente_id")
	private Docente docente;

	private String anioLectivo;

	private Date fechaInicio;

	private Date fechaFin;

	@OneToMany(mappedBy = "comision")
	private List<PlanificacionCursado> horarios;

	@OneToMany(mappedBy = "comision")
	private List<ExamenParcial> parciales;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MateriaCarrera getMateriaCarrera() {
		return materiaCarrera;
	}

	public void setMateriaCarrera(MateriaCarrera materiaCarrera) {
		this.materiaCarrera = materiaCarrera;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getAnioLectivo() {
		return anioLectivo;
	}

	public void setAnioLectivo(String anioLectivo) {
		this.anioLectivo = anioLectivo;
	}

	public List<PlanificacionCursado> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<PlanificacionCursado> horarios) {
		this.horarios = horarios;
	}

	public List<ExamenParcial> getParciales() {
		return parciales;
	}

	public void setParciales(List<ExamenParcial> parciales) {
		this.parciales = parciales;
	}

	public Date getFechainicio() {
		return fechaInicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechaInicio = fechainicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
