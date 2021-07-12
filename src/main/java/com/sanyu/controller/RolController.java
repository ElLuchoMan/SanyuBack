package com.sanyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.entity.Rol;
import com.sanyu.service.RolService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {
	// Servicio a utilizar
	@Autowired
	RolService rolService;

	// Método que trae todos los roles
	@GetMapping("/")
	@ApiOperation(value = "Método que trae todos los roles")
	public ResponseEntity<List<Rol>> getLista() {
		List<Rol> lista = rolService.obtenerTodos();
		return new ResponseEntity<List<Rol>>(lista, HttpStatus.OK);
	}
}
