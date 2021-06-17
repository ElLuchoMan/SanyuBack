package com.sanyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.sanyu.entity.Rol;
import com.sanyu.service.RolService;

import io.swagger.annotations.ApiOperation;

public class RolController {
	@Autowired
	RolService rolService;

	@GetMapping("/")
	@ApiOperation(value = "Método que trae todos los roles")
	public ResponseEntity<List<Rol>> getLista() {
		List<Rol> lista = rolService.obtenerTodos();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}
}
