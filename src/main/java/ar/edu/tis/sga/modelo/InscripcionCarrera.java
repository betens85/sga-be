package ar.edu.tis.sga.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscripcion_carrera")
public class InscripcionCarrera extends Inscripcion {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario creadoPor;

	private String cicloLectivoInicio;

	@Column(nullable = false)
	private Date fechaInicioCursado;

	@Column(nullable = false)
	private Date fechaFinCursado;

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Usuario getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(Usuario creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getCicloLectivoInicio() {
		return cicloLectivoInicio;
	}

	public void setCicloLectivoInicio(String cicloLectivoInicio) {
		this.cicloLectivoInicio = cicloLectivoInicio;
	}

	public Date getFechaInicioCursado() {
		return fechaInicioCursado;
	}

	public void setFechaInicioCursado(Date fechaInicioCursado) {
		this.fechaInicioCursado = fechaInicioCursado;
	}

	public Date getFechaFinCursado() {
		return fechaFinCursado;
	}

	public void setFechaFinCursado(Date fechaFinCursado) {
		this.fechaFinCursado = fechaFinCursado;
	}

}
