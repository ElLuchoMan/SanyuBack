package com.sanyu.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanyu.entity.Rol;
import com.sanyu.repository.RolRepository;

@Service
@Transactional
public class RolService {
	@Autowired
	RolRepository rolRepository;

	public List<Rol> obtenerTodos() {
		List<Rol> lista = rolRepository.findAll();
		return lista;
	}

	public Optional<Rol> getByRolNombre(String nombreRol) {
		return rolRepository.findByRolNombre(nombreRol);
	}
}
