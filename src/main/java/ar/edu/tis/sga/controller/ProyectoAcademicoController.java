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
import org.springframework.web.bind.annotation.RestController;

import ar.edu.tis.sga.dao.ProyectoAcademicoDAO;
import ar.edu.tis.sga.modelo.ProyectoAcademico;
import ar.edu.tis.sga.modelo.Resultado;

@RestController
@RequestMapping("/api")
public class ProyectoAcademicoController {

	@Autowired
	ProyectoAcademicoDAO proyectoAcademicoDAO;

	@GetMapping("/proyectos")
	public List<ProyectoAcademico> getAll() {
		return proyectoAcademicoDAO.findAll();
	}

	@PostMapping("/proyectos")
	public ProyectoAcademico create(@Valid @RequestBody ProyectoAcademico proyectoAcademico) {
		return proyectoAcademicoDAO.save(proyectoAcademico);
	}

	@PutMapping("/proyectos/{id}")
	public ResponseEntity<ProyectoAcademico> updateResultado(@PathVariable(value = "id") Long proyectoAcademicoId,
			@Valid @RequestBody ProyectoAcademico proyectoAcademico) {

		ProyectoAcademico proyectoAcademicoResult = proyectoAcademicoDAO.findOne(proyectoAcademicoId);

		if (proyectoAcademicoResult == null) {
			return ResponseEntity.notFound().build();
		}

		ProyectoAcademico updated = proyectoAcademicoDAO.save(proyectoAcademicoResult);
		return ResponseEntity.ok(updated);
	}
}
