package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscripcion_materia")
public class InscripcionMateria extends Inscripcion {

	@OneToOne
	@JoinColumn(name = "comision_id")
	private Comision comision;

	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

}
