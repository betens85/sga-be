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

import ar.edu.tis.sga.dao.ComisionDAO;
import ar.edu.tis.sga.modelo.Comision;

@RestController
@RequestMapping("/api")
public class ComisionController {

	@Autowired
	ComisionDAO comisionDAO;

	@GetMapping("/comisiones")
	public List<Comision> getAll() {
		return comisionDAO.findAll();
	}

	@PostMapping("/comisiones")
	public Comision create(@Valid @RequestBody Comision comision) {
		return comisionDAO.save(comision);
	}

	@GetMapping("/comisiones/{id}")
	public ResponseEntity<Comision> getById(@PathVariable(value = "id") Long comisionId) {
		Comision comision = comisionDAO.findOne(comisionId);
		if (comision == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(comision);
	}

	@PutMapping("/comisiones/{id}")
	public ResponseEntity<Comision> update(@PathVariable(value = "id") Long comisionId,
			@Valid @RequestBody Comision comisionDetails) {

		Comision comision = comisionDAO.findOne(comisionId);
		if (comision == null) {
			return ResponseEntity.notFound().build();
		}
	

		Comision updated = comisionDAO.save(comision);
		return ResponseEntity.ok(updated);
	}

}
