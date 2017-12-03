package ar.edu.tis.sga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.tis.sga.modelo.InscripcionMateria;

@Repository
public interface InscripcionMateriaDAO extends JpaRepository<InscripcionMateria, Long> {

}
