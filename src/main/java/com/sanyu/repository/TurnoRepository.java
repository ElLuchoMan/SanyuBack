package com.sanyu.repository;

import org.springframework.stereotype.Repository;

import com.sanyu.entity.Contratista;
import com.sanyu.entity.Turno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {

	Optional<Turno> findById(Integer idTurno);

	// boolean existById(Integer idTurno);

	void deleteById(Integer idTurno);

	public Turno save(Turno turno);

	@Query(value = "SELECT DISTINCT t.* FROM contratista c, turno t, turno_contratista tc where tc.k_documento = c.k_documento AND c.k_documento=:documento AND t.o_estado='Activo'", nativeQuery = true)
	//
	public List<Turno> findByContratista(@Param("documento") Integer documento);

}