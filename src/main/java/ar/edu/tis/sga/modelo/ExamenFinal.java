package ar.edu.tis.sga.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "examen_final")
public class ExamenFinal extends Examen {

	private String mesa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_carrera_id")
	private MateriaCarrera materiaCarrera;

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	
	public MateriaCarrera getMateriaCarrera() {
		return materiaCarrera;
	}

	public void setMateriaCarrera(MateriaCarrera materiaCarrera) {
		this.materiaCarrera = materiaCarrera;
	}
	
}
