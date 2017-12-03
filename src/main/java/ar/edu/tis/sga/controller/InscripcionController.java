package ar.edu.tis.sga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.tis.sga.dao.InscripcionCarreraDAO;
import ar.edu.tis.sga.dao.InscripcionExamenDAO;
import ar.edu.tis.sga.dao.InscripcionMateriaDAO;
import ar.edu.tis.sga.modelo.InscripcionCarrera;
import ar.edu.tis.sga.modelo.InscripcionExamen;
import ar.edu.tis.sga.modelo.InscripcionMateria;

public class InscripcionController {

	@Autowired
	InscripcionCarreraDAO inscripcionCarreraDAO;

	@Autowired
	InscripcionMateriaDAO inscripcionMateriaDAO;
	
	@Autowired
	InscripcionExamenDAO inscripcionExamenDAO;

	@GetMapping("/inscripciones/carreras")
	public List<InscripcionCarrera> getAllInscripcionCarrera() {
		return inscripcionCarreraDAO.findAll();
	}

	@GetMapping("/inscripciones/materias")
	public List<InscripcionMateria> getAllInscripcionMateria() {
		return inscripcionMateriaDAO.findAll();
	}
	
	@GetMapping("/inscripciones/examenes")
	public List<InscripcionExamen> getAllInscripcionExamen() {
		return inscripcionExamenDAO.findAll();
	}

	@PostMapping("/inscripciones/carreras")
	public InscripcionCarrera createInscripcionCarrera(@Valid @RequestBody InscripcionCarrera inscripcionCarrera) {
		return inscripcionCarreraDAO.save(inscripcionCarrera);
	}

	@PostMapping("/inscripciones/materias")
	public InscripcionMateria createInscripcionMateria(@Valid @RequestBody InscripcionMateria inscripcionMateria) {
		return inscripcionMateriaDAO.save(inscripcionMateria);
	}
	
	@PostMapping("/inscripciones/examenes")
	public InscripcionExamen createInscripcionExamen(@Valid @RequestBody InscripcionExamen inscripcionExamen) {
		return inscripcionExamenDAO.save(inscripcionExamen);
	}

}
