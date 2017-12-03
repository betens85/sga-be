package ar.edu.tis.sga.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.tis.sga.dao.UsuarioDAO;
import ar.edu.tis.sga.modelo.Usuario;
import ar.edu.tis.sga.util.SGAUtil;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;

	@PostMapping("/usuarios")
	public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {
		usuario.setFechaAlta(new Date());
		usuario.setLegajo(SGAUtil.generarLegajo(6));
		return usuarioDAO.save(usuario);
	}

	@GetMapping("/usuarios")
	public List<Usuario> getAll() {
		return usuarioDAO.findAll();
	}

	@GetMapping("/usuarios/email")
	public ResponseEntity<Usuario> checkEmailExists(@RequestParam String email) {
		Usuario resultado = usuarioDAO.findByEmail(email);

		if (resultado == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(resultado);
	}

	@PostMapping("/usuarios/login")
	public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String password) {

		final Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);

		Usuario userLogged = usuarioDAO.findOne(Example.of(usuario));

		if (userLogged == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(userLogged);
	}

}
