package com.sanyu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Turno;
import com.sanyu.repository.TurnoRepository;

@Service
@Transactional
public class TurnoService {
	// Repositorio a utilizar
	@Autowired
	TurnoRepository turnoRepository;

	// Método que pemrite encontrar un turno mediante su ID
	public Optional<Turno> findById(Integer idTurno) {
		return turnoRepository.findById(idTurno);
	}

	// Método que permite guardar un turno
	public void guardar(Turno turno) {
		turnoRepository.save(turno);
	}

	// Método que permite hacer borrado físico de un turno
	public void deleteById(Integer idTurno) {
		turnoRepository.deleteById(idTurno);

	}

	// Método que permite listar todos los turnos registrados
	public List<Turno> obtenerTodos() {
		List<Turno> lista = turnoRepository.findAll();
		return lista;
	}

	// Método que permite verificar si existe un turno mediante su ID
	public boolean existsByIdTurno(Integer idTurno) {
		return turnoRepository.existsByIdTurno(idTurno);
	}

	// Método que permite traer el turno del día para el contratista
	public List<Turno> findByContratista(Integer documento) {
		return turnoRepository.findByContratista(documento);
	}

	// Método que permite traer la información de los turnos registrados para los contratistas
	public Turno findByTurno(Integer documento) {
		return turnoRepository.findByTurno(documento);
	}

}
