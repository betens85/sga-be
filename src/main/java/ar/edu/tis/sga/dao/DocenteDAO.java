package ar.edu.tis.sga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.tis.sga.modelo.Docente;

@Repository
public interface DocenteDAO extends JpaRepository<Docente, Long> {

}
