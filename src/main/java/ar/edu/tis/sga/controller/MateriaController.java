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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.tis.sga.dao.MateriaDAO;
import ar.edu.tis.sga.modelo.Materia;
import ar.edu.tis.sga.modelo.Resultado;

@RestController
@RequestMapping("/api")
public class MateriaController {

	@Autowired
	MateriaDAO materiaDAO;

	@GetMapping("/materias")
	public List<Materia> getAll() {
		return materiaDAO.findAll();
	}

	@PostMapping("/materias")
	public Materia create(@Valid @RequestBody Materia materia) {
		return materiaDAO.save(materia);
	}

	@PutMapping("/materias/{id}")
	public ResponseEntity<Materia> update(@PathVariable(value = "id") Long materiaId,
			@RequestBody Materia materiaToUpdate) {
		Materia materia = materiaDAO.findOne(materiaId);

		if (materia == null) {
			return ResponseEntity.notFound().build();
		}

		materia.setCorrelativas(materiaToUpdate.getCorrelativas());

		Materia updatedMateria = materiaDAO.save(materia);
		return ResponseEntity.ok(updatedMateria);
	}

	@GetMapping("/materias/{id}")
	public ResponseEntity<Materia> getById(@PathVariable(value = "id") Long materiaId) {
		Materia materia = materiaDAO.findOne(materiaId);
		if (materia == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(materia);
	}
}
