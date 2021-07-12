package com.sanyu.repository;

import org.springframework.stereotype.Repository;

import com.sanyu.entity.Turno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
	// Método que permite encontrar un turno mediante su ID
	Optional<Turno> findById(Integer idTurno);

	// Método que permite verificar si existe un turno mediante su ID
	boolean existsByIdTurno(Integer documento);

	// Método que permite hacer borrado físico un turno mediante su ID
	void deleteById(Integer idTurno);

	// Consulta que permite traer el turno del día para el contratista
	@Query(value = "SELECT t.* FROM contratista c INNER JOIN turno_contratista tc ON c.k_documento=tc.k_documento INNER JOIN turno t ON t.k_idturno=tc.k_idturno AND c.k_documento=:documento AND t.o_estado='Activo' AND t.f_fechainicio>=to_char(current_date)", nativeQuery = true)
	public List<Turno> findByContratista(@Param("documento") Integer documento);

	// Consulta que permite traer la información de los turnos registrados para los contratistas
	@Query(value = "SELECT t.* FROM contratista c INNER JOIN turno_contratista tc ON c.k_documento=tc.k_documento INNER JOIN turno t ON t.k_idturno=tc.k_idturno AND c.k_documento=:documento AND t.f_fechainicio=to_char(current_date) AND t.o_estado='Activo'", nativeQuery = true)
	public Turno findByTurno(@Param("documento") Integer documento);
}