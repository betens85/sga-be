package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planificacion_cursado")
public class PlanificacionCursado extends Planificacion {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comision_id")
	private Comision comision;

	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemana;

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

}
