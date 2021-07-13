package com.sanyu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Jornada;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {
	// Método que trae la lista de todas las jornadas activas
	@Query("FROM Jornada j WHERE j.estadoJornada='Activo'")
	public List<Jornada> obtenerTodos();

}
