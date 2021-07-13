package com.sanyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.entity.Jornada;
import com.sanyu.service.JornadaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/jornadas")
@CrossOrigin(origins = "*")
public class JornadaController {
	// Servicio a utilizar
	@Autowired
	JornadaService jornadaService;

	// Método que trae todas las jornadas activas
	@GetMapping("/")
	@ApiOperation(value = "Método que trae todas las jornadas")
	public ResponseEntity<List<Jornada>> getLista() {
		List<Jornada> lista = jornadaService.obtenerTodos();
		return new ResponseEntity<List<Jornada>>(lista, HttpStatus.OK);
	}
}
