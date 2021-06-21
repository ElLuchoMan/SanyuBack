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

}