package com.sanyu.service;

import java.util.Optional;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Contratista;
import com.sanyu.repository.ContratistaRepository;

@Service
@Transactional
public class ContratistaService {
	// Repositorio a utilizar
	@Autowired
	ContratistaRepository contratistaRepository;

	// M�todo para encontrar un contratista mediante su documento
	public Optional<Contratista> obtenerPorDocumento(Integer documento) {
		return contratistaRepository.findByDocumento(documento);
	}

	// M�todo que permite verificar si existe un contratista mediante su documento
	public boolean existsByDocumento(Integer documento) {
		return contratistaRepository.existsByDocumento(documento);
	}

	// M�todo que permite listar todos los contratistas activos
	public List<Contratista> obtenerTodos() {
		List<Contratista> lista = contratistaRepository.obtenerTodos();
		return lista;
	}

	// M�todo que permite guardar un contratista en la base de datos
	public void guardar(Contratista contratista) {
		contratistaRepository.save(contratista);
	}

	// M�todo que permite realizar borrado f�sico de un contratista
	public void borrar(Number documento) {
		contratistaRepository.deleteById(documento);
	}

	// M�todo que permite mostrar contratistas sin turno
	public List<Contratista> contratistaSinTurno() {
		return contratistaRepository.contratistaSinTurno();
	}
}
