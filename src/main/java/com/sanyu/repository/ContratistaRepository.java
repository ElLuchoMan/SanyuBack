package com.sanyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Contratista;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratistaRepository extends JpaRepository<Contratista, Number> {
	// Método que permite encontrar un contratista mediante su documento
	Optional<Contratista> findByDocumento(Integer documento);

	// Método que permite verificar si existe un contratista mediante su documento
	boolean existsByDocumento(Integer documento);

	// Método que permite hacer borrado físico de un contratista mediante su documento
	void deleteById(Number documento);

	// Consulta que permite traer de la base de datos los contratistas que tengan rol de campo y que no tengan turnos asignados
	@Query(value = "SELECT  /*+ ALL_ROWS */ c.* FROM contratista c WHERE NOT EXISTS (SELECT * FROM turno_contratista t  WHERE t.k_documento = c.k_documento ) AND c.o_estadocontratista='Activo' AND c.k_idrol =2", nativeQuery = true)
	public List<Contratista> contratistaSinTurno();

	// Consulta que permite traer de la base de datos los contratistas que se encuentren activos
	@Query("FROM Contratista c WHERE c.estadoContratista='Activo'")
	public List<Contratista> obtenerTodos();
}
