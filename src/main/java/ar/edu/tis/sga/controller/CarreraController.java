package ar.edu.tis.sga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.edu.tis.sga.dao.CarreraDAO;
import ar.edu.tis.sga.modelo.Carrera;

public class CarreraController {

	@Autowired
	CarreraDAO carreraDAO;

	@GetMapping("/carreras")
	public List<Carrera> getAll() {
		return carreraDAO.findAll();
	}

	@PostMapping("/carreras")
	public Carrera create(@Valid @RequestBody Carrera carrera) {
		return carreraDAO.save(carrera);
	}

	@PutMapping("/carreras/{id}")
	public ResponseEntity<Carrera> update(@PathVariable(value = "id") Long carreraId,
			@RequestBody Carrera carreraToUpdate) {
		Carrera carrera = carreraDAO.findOne(carreraId);

		if (carrera == null) {
			return ResponseEntity.notFound().build();
		}

		carrera.setNombre(carreraToUpdate.getNombre());
		carrera.setDocenteTutor(carreraToUpdate.getDocenteTutor());
		carrera.setDescripcion(carreraToUpdate.getDescripcion());

		Carrera updatedCarrera = carreraDAO.save(carrera);
		return ResponseEntity.ok(updatedCarrera);
	}

	@GetMapping("/carreras/{id}")
	public ResponseEntity<Carrera> getById(@PathVariable(value = "id") Long materiaId) {
		Carrera carrera = carreraDAO.findOne(materiaId);
		if (carrera == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(carrera);
	}
}
