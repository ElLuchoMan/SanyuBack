package com.sanyu.service;

import java.util.Optional;

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

	public Optional<Contratista> findyByName(String nombre) {
		return contratistaRepository.findByName(nombre);
	}

	public Optional<Contratista> findByDocument(Number documento) {
		return contratistaRepository.findByDocument(documento);
	}

	public boolean existsByDocument(Number documento) {
		return contratistaRepository.existsByDocument(documento);
	}
}
