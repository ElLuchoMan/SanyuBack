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

	//@Query(value = "SELECT FROM Turno JOIN Contratista ON Contratista.idTurno = turno.idTurno")
	//public List<Contratista> findByContratista(@Param("documento") Integer documento);

}
