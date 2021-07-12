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
	// Repositorio a utilizar
	@Autowired
	CompaniaRepository companiaRepository;

	// Método para cargar la compania mediante su NIT
	public Optional<Compania> findById(Integer nitCompania) {
		return companiaRepository.findById(nitCompania);
	}

	// Método para saber si la compania existe mediante su NIT
	public boolean existstById(Integer nitCompania) {
		return companiaRepository.existsById(nitCompania);
	}

	// Meotodo para obtener lista de todas las companias
	public List<Compania> obtenerTodos() {
		List<Compania> lista = companiaRepository.findAll();
		return lista;
	}
}
