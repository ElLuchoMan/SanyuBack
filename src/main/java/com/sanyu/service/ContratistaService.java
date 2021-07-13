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

	// Método para encontrar un contratista mediante su documento
	public Optional<Contratista> obtenerPorDocumento(Integer documento) {
		return contratistaRepository.findByDocumento(documento);
	}

	// Método que permite verificar si existe un contratista mediante su documento
	public boolean existsByDocumento(Integer documento) {
		return contratistaRepository.existsByDocumento(documento);
	}

	// Método que permite listar todos los contratistas activos
	public List<Contratista> obtenerTodos() {
		List<Contratista> lista = contratistaRepository.obtenerTodos();
		return lista;
	}

	// Método que permite guardar un contratista en la base de datos
	public void guardar(Contratista contratista) {
		contratistaRepository.save(contratista);
	}

	// Método que permite realizar borrado físico de un contratista
	public void borrar(Number documento) {
		contratistaRepository.deleteById(documento);
	}

	// Método que permite mostrar contratistas sin turno
	public List<Contratista> contratistaSinTurno() {
		return contratistaRepository.contratistaSinTurno();
	}
}
