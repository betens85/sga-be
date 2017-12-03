package ar.edu.tis.sga.modelo;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Examen implements Serializable {

	private static final long serialVersionUID = 1032099806680231852L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descripcion;

	private String anioLectivo;
	
	@Enumerated(EnumType.STRING)
	private TipoExamen tipoExamen;
	
	@OneToOne
	@JoinColumn(name = "docente_id")
	private Docente docente;

	@OneToOne
	@JoinColumn(name = "planificacion_id")
	private PlanificacionExamen planificacion;

	
	public PlanificacionExamen getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(PlanificacionExamen planificacion) {
		this.planificacion = planificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}
	
	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

}
