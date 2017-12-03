package ar.edu.tis.sga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.tis.sga.dao.DocenteDAO;
import ar.edu.tis.sga.modelo.Docente;

@RestController
@RequestMapping("/api")
public class DocenteController {
	
	@Autowired
	DocenteDAO docenteDAO;

	@GetMapping("/docentes")
	public List<Docente> getAll() {
		return docenteDAO.findAll();
	}
	
	@PostMapping("/docentes")
	public Docente createAlumno(@Valid @RequestBody Docente docente) {
		return docenteDAO.save(docente);
	}
}
