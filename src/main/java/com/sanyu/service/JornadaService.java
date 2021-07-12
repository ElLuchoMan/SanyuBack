package com.sanyu.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Jornada;
import com.sanyu.repository.JornadaRepository;

@Service
@Transactional
public class JornadaService {
	// Repositorio a utilizar
	@Autowired
	JornadaRepository jornadaRepository;

	//Obtener todas las jornadas
	public List<Jornada> obtenerTodos() {
		List<Jornada> lista = jornadaRepository.findAll();
		return lista;
	}
}
