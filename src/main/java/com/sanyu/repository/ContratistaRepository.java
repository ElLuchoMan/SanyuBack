package com.sanyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Contratista;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratistaRepository extends JpaRepository<Contratista, Number> {
	Optional<Contratista> findByDocumento(Integer documento);

	boolean existsByDocumento(Integer documento);

	void deleteById(Number documento);


	@Query(value = "SELECT c.* FROM contratista c WHERE NOT EXISTS (SELECT * FROM turno_contratista t  WHERE t.k_documento = c.k_documento )", nativeQuery = true)
	public List<Contratista> contratistaSinTurno();

	@Query(value = "SELECT * FROM TURNO_CONTRATISTA, contratista WHERE contratista.k_documento=:documento AND turno_contratista.k_documento=contratista.k_documento", nativeQuery = true)
	public List<Contratista> findByContratista(@Param("documento") Integer documento);





	// @Query(value = "SELECT FROM Turno JOIN Contratista ON Contratista.idTurno =
	// turno.idTurno")
	// public List<Contratista> findByContratista(@Param("documento") Integer
	// documento);

}
