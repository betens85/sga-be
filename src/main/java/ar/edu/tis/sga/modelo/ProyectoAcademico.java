package ar.edu.tis.sga.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto_academico")
public class ProyectoAcademico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String descripcion;

	@Column(nullable = false)
	private Date fechaInicio;

	@Column(nullable = false)
	private Date fechaFin;

	@OneToMany(mappedBy = "proyectoAcademico")
	private Set<AsignacionProyecto> asignaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Set<AsignacionProyecto> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Set<AsignacionProyecto> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
