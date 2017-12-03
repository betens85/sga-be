package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examen_parcial")
public class ExamenParcial extends Examen {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comision_id")
	private Comision comision;
	
	public Comision getComision() {
		return comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}


}
