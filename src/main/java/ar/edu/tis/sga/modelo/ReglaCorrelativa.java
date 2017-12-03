package ar.edu.tis.sga.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regla_correlativa")
public class ReglaCorrelativa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "materia_origen_id")
	private Materia materia;

	@Enumerated(EnumType.STRING)
	private PropositoCorrelativa propositoCorrelativa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_requerida_id")
	private Materia materiaRequerida;

	@Enumerated(EnumType.STRING)
	private EstadoMateria estadoMateriaRequerida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public PropositoCorrelativa getPropositoCorrelativa() {
		return propositoCorrelativa;
	}

	public void setPropositoCorrelativa(PropositoCorrelativa propositoCorrelativa) {
		this.propositoCorrelativa = propositoCorrelativa;
	}

	public EstadoMateria getEstadoMateriaRequerida() {
		return estadoMateriaRequerida;
	}

	public void setEstadoMateriaRequerida(EstadoMateria estadoMateriaRequerida) {
		this.estadoMateriaRequerida = estadoMateriaRequerida;
	}

	public Materia getMateriaRequerida() {
		return materiaRequerida;
	}

	public void setMateriaRequerida(Materia materiaRequerida) {
		this.materiaRequerida = materiaRequerida;
	}

}
