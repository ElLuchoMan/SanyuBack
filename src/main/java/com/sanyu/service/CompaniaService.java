package com.sanyu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Compania;
import com.sanyu.repository.CompaniaRepository;

@Service
@Transactional
public class CompaniaService {
	@Autowired
	CompaniaRepository companiaRepository;

	public Optional<Compania> findById(Integer nitCompania) {
		return companiaRepository.findById(nitCompania);
	}

	public boolean existstById(Integer nitCompania) {
		return companiaRepository.existsById(nitCompania);
	}

	public List<Compania> obtenerTodos() {
		List<Compania> lista = companiaRepository.findAll();
		return lista;
	}

}
