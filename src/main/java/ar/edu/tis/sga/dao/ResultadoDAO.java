package ar.edu.tis.sga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.tis.sga.modelo.Resultado;

@Repository
public interface ResultadoDAO extends JpaRepository<Resultado, Long> {

}