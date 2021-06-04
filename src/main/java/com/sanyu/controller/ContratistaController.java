package com.sanyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.service.ContratistaService;
import com.sanyu.DTO.Mensaje;
import com.sanyu.entity.Contratista;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/contratistas")
@CrossOrigin(origins = "*")
public class ContratistaController {
	@Autowired
	ContratistaService contratistaService;

	@GetMapping("/")
	@ApiOperation(value = "Método que trae la lista de todos los contratistas")
	public ResponseEntity<List<Contratista>> getLista() {
		List<Contratista> lista = contratistaService.obtenerTodos();
		return new ResponseEntity<List<Contratista>>(lista, HttpStatus.OK);
	}
	@GetMapping("/{documento}")
	@ApiOperation(value="Método que trae una persona mediante su documento")
	public ResponseEntity<Contratista> getOne(@PathVariable Number documento) {
		if (!contratistaService.existsByDocumento(documento))
			return new ResponseEntity(new Mensaje("No existe una persona con ese documento"), HttpStatus.NOT_FOUND);
		Contratista contratista = contratistaService.obtenerPorDocumento(documento).get();
		return new ResponseEntity<Contratista>(contratista, HttpStatus.OK);
	}
	
}
