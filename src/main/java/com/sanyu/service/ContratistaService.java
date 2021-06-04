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

	public Optional<Contratista> findByDocumento(Number documento) {
		return contratistaRepository.findByDocumento(documento);
	}

	public boolean existsByDocumento(Number documento) {
		return contratistaRepository.existsByDocumento(documento);
	}

}
