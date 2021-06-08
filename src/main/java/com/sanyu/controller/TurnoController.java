package com.sanyu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.entity.Contratista;
import com.sanyu.entity.Turno;
import com.sanyu.service.TurnoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {
	
	@Autowired
	TurnoService turnoService;

	@GetMapping("/")
	@ApiOperation(value = "Método que trae la lista de todos los turnos registrados")
	public ResponseEntity<List<Turno>> getLista() {
		List<Turno> lista = turnoService.obtenerTodos();
		return new ResponseEntity<List<Turno>>(lista, HttpStatus.OK);
	}
	//@RequestMapping(method = RequestMethod.GET)
	//@GetMapping("/{documento}")
	//@ApiOperation(value = "Método que trae una casa por direccion")
	//public List<Turno> encontrarDireccion(@RequestParam("documento") Integer documento) {
	//	return turnoService.findByContratista(documento);
	//}
}
