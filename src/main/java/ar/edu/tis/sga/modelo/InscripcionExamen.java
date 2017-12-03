package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscripcion_examen")
public class InscripcionExamen extends Inscripcion {

	@OneToOne
	@JoinColumn(name = "planificacion_id")
	private PlanificacionExamen planificacion;

	@Enumerated(EnumType.STRING)
	private TipoExamen tipoExamen;

	public PlanificacionExamen getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(PlanificacionExamen planificacion) {
		this.planificacion = planificacion;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

}
