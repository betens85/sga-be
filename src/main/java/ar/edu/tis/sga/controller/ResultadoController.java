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

import ar.edu.tis.sga.dao.ResultadoDAO;
import ar.edu.tis.sga.modelo.Resultado;

@RestController
@RequestMapping("/api")
public class ResultadoController {

	@Autowired
	ResultadoDAO resultadoDAO;

	@GetMapping("/resultados")
	public List<Resultado> getAllResultados() {
		return resultadoDAO.findAll();
	}

	@PostMapping("/resultados")
	public Resultado createResultado(@Valid @RequestBody Resultado resultado) {
		return resultadoDAO.save(resultado);
	}

	@GetMapping("/resultados/{id}")
	public ResponseEntity<Resultado> getNoteById(@PathVariable(value = "id") Long resultadoId) {
		Resultado resultado = resultadoDAO.findOne(resultadoId);
		if (resultado == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(resultado);
	}

	@PutMapping("/resultados/{id}")
	public ResponseEntity<Resultado> updateResultado(@PathVariable(value = "id") Long resultadoId,
			@Valid @RequestBody Resultado resultadoDetails) {
		
		Resultado resultado = resultadoDAO.findOne(resultadoId);
		if (resultado == null) {
			return ResponseEntity.notFound().build();
		}
		resultado.setComentario(resultadoDetails.getComentario());
		resultado.setNota(resultadoDetails.getNota());

		Resultado updatedResultado = resultadoDAO.save(resultado);
		return ResponseEntity.ok(updatedResultado);
	}

}
