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
	@Autowired
	ContratistaRepository contratistaRepository;

	public Optional<Contratista> findByDocumento(Integer documento) {
		return contratistaRepository.findByDocumento(documento);
	}

	public boolean existsByDocumento(Integer documento) {
		return contratistaRepository.existsByDocumento(documento);
	}

	public List<Contratista> obtenerTodos() {
		List<Contratista> lista = contratistaRepository.findAll();
		return lista;
	}

	public Optional<Contratista> obtenerPorDocumento(Integer documento) {
		return contratistaRepository.findByDocumento(documento);
	}

	public void guardar(Contratista contratista) {
		contratistaRepository.save(contratista);
	}

	public void borrar(Number documento) {
		contratistaRepository.deleteById(documento);
	}

	public List<Contratista> contratistaSinTurno() {
		return contratistaRepository.contratistaSinTurno();
	}
}
