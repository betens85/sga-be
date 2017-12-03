package ar.edu.tis.sga.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planificacion_examen")
public class PlanificacionExamen extends Planificacion {

	@Column(nullable = false)
	private Date fecha;// NO APLICA PARA CURSADO (EVENTO REPETITIVO)

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
