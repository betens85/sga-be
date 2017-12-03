package ar.edu.tis.sga.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.tis.sga.dao.AlumnoDAO;
import ar.edu.tis.sga.modelo.Alumno;

@RestController
@RequestMapping("/api")
public class AlumnoController {
	
	@Autowired
	AlumnoDAO alumnoDAO;

	@GetMapping("/alumnos")
	public List<Alumno> getAll() {
		return alumnoDAO.findAll();
	}
	
	@PostMapping("/alumnos")
	public Alumno createAlumno(@Valid @RequestBody Alumno alumno) {
		return alumnoDAO.save(alumno);
	}
}
