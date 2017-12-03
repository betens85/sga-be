package ar.edu.tis.sga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.tis.sga.modelo.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

	@Query("SELECT f FROM Usuario f WHERE LOWER(f.email) = LOWER(:email) AND LOWER(f.password) = LOWER(:password)")
	Usuario retrieveByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query("SELECT f FROM Usuario f WHERE LOWER(f.email) = LOWER(:email)")
	Usuario findByEmail(@Param("email") String email);

}
