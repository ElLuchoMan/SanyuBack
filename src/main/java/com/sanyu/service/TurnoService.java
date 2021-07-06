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
	@Autowired
	TurnoRepository turnoRepository;

	public Optional<Turno> findById(Integer idTurno) {
		return turnoRepository.findById(idTurno);
	}

	public void guardar(Turno turno) {
		turnoRepository.save(turno);
	}

	public void borrar(Integer idTurno) {
		turnoRepository.deleteById(idTurno);
	}

	public List<Turno> obtenerTodos() {
		List<Turno> lista = turnoRepository.findAll();
		return lista;
	}

	public void deleteById(Integer idTurno) {
		turnoRepository.deleteById(idTurno);

	}

	public boolean existsByIdTurno(Integer idTurno) {
		return turnoRepository.existsByIdTurno(idTurno);
	}

	public Optional<Turno> obtenerPorId(Integer documento) {
		return turnoRepository.findById(documento);
	}

	public List<Turno> findByContratista(Integer documento) {
		return turnoRepository.findByContratista(documento);
	}

}
