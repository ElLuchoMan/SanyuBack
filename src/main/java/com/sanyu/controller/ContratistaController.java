package com.sanyu.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	// Servicio a utilizar
	@Autowired
	ContratistaService contratistaService;

	// Método que trae la lista de todos los contratistas registrados que se
	// encuentran activos
	@GetMapping("/")
	@ApiOperation(value = "Método que trae la lista de todos los contratistas activos")
	public ResponseEntity<List<Contratista>> getLista() {
		List<Contratista> lista = contratistaService.obtenerTodos();
		return new ResponseEntity<List<Contratista>>(lista, HttpStatus.OK);
	}

	// Método que trae a un contratista mediante su documento
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/{documento}")
	@ApiOperation(value = "Método que trae a un contratista mediante su documento")
	public ResponseEntity<Contratista> getOne(@PathVariable Integer documento) {
		// Valida si existe una persona con ese documento
		if (!contratistaService.existsByDocumento(documento))
			return new ResponseEntity(new Mensaje("No existe una persona con ese documento"), HttpStatus.NOT_FOUND);
		Contratista contratista = contratistaService.obtenerPorDocumento(documento).get();
		return new ResponseEntity<Contratista>(contratista, HttpStatus.OK);
	}

	// Traer información de contratistas sin turno
	@GetMapping("/SinTurno")
	@ApiOperation(value = "Método que trae los contratistas sin turno")
	public ResponseEntity<List<Contratista>> getSinTurnos() {
		List<Contratista> contratista = contratistaService.contratistaSinTurno();
		return new ResponseEntity<List<Contratista>>(contratista, HttpStatus.OK);
	}

	// Método que permite registrar a un contratista
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/nuevo")
	@ApiOperation(value = "Método que permite registrar a un contratista")
	public ResponseEntity<?> create(@RequestBody Contratista contratista) {
		// Se valida que el body contenga un documento
		if (contratista.getDocumento() == null)
			return new ResponseEntity(new Mensaje("El documento es obligatorio"), HttpStatus.BAD_REQUEST);
		// Se valida que el body contenta un nombre de contratista
		if (StringUtils.isBlank(contratista.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		// Valida si el documento ya está registrado
		if (contratistaService.existsByDocumento(contratista.getDocumento()))
			return new ResponseEntity(new Mensaje("Ese documento ya est� registrado"), HttpStatus.BAD_REQUEST);
		try {
			contratistaService.guardar(contratista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new Mensaje("Persona guardada"), HttpStatus.CREATED);
	}

	// Método que permite actualizar un contratista mediante su documento
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar/{documento}")
	@ApiOperation(value = "Método que permite actualizar un contratista mediante su documento")
	public ResponseEntity<?> update(@RequestBody Contratista contratista,
			@PathVariable("documento") Integer documento) {
		if (!contratistaService.existsByDocumento(documento))
			return new ResponseEntity(new Mensaje("No existe esa persona"), HttpStatus.NOT_FOUND);
		if (StringUtils.isBlank(contratista.getNombre()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Contratista contratistaUpdate = contratistaService.obtenerPorDocumento(documento).get();
		contratistaUpdate.setDocumento(contratista.getDocumento());
		contratistaUpdate.setNombre(contratista.getNombre());
		contratistaUpdate.setTelefono(contratista.getTelefono());
		contratistaUpdate.setPassword(contratista.getPassword());
		contratistaService.guardar(contratistaUpdate);
		return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.CREATED);
	}

}
