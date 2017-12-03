package ar.edu.tis.sga.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Planificacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String horaInicio;

	@Column(nullable = false)
	private String horaFin;

	@Enumerated(EnumType.STRING)
	private TipoPlanificacion tipoPlanificacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public TipoPlanificacion getTipoPlanificacion() {
		return tipoPlanificacion;
	}

	public void setTipoPlanificacion(TipoPlanificacion tipoPlanificacion) {
		this.tipoPlanificacion = tipoPlanificacion;
	}

}
