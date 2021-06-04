package com.sanyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sanyu.service.ContratistaService;
import com.sanyu.DTO.Mensaje;
import com.sanyu.entity.Contratista;
import com.sanyu.entity.Rol;

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
	@ApiOperation(value = "Método que trae a un contratista mediante su documento")
	public ResponseEntity<Contratista> getOne(@PathVariable Integer documento) {
		if (!contratistaService.existsByDocumento(documento))
			return new ResponseEntity(new Mensaje("No existe una persona con ese documento"), HttpStatus.NOT_FOUND);
		Contratista contratista = contratistaService.obtenerPorDocumento(documento).get();
		return new ResponseEntity<Contratista>(contratista, HttpStatus.OK);
	}

	@PostMapping("/nuevo")
	@ApiOperation(value = "Método que permite registrar a un contratista")
	public ResponseEntity<?> create(@RequestBody Contratista contratista) {
		
		//if (StringUtils.isBlank(persona.getDocumento()))
			//return new ResponseEntity(new Mensaje("El documento es obligatorio"), HttpStatus.BAD_REQUEST);
		//if (StringUtils.isBlank(persona.getNombre()))
			//return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if (contratistaService.existsByDocumento(contratista.getDocumento()))
			return new ResponseEntity(new Mensaje("Ese documento ya est� registrado"), HttpStatus.BAD_REQUEST);
		contratistaService.guardar(contratista);
		return new ResponseEntity(new Mensaje("Persona guardada"), HttpStatus.CREATED);
	}

}
