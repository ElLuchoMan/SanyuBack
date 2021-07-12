package com.sanyu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Jornada;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {
	// Método que permite encontrar una jornada mediante su ID
	Optional<Jornada> findById(Integer idJornada);
}
