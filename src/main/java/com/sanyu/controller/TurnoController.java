package com.sanyu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.DTO.Mensaje;
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

	// crear turno
	@PostMapping
	@ApiOperation(value = "Método que permite crear un turno")
	public ResponseEntity<?> create(@RequestBody Turno turno) {
		// return
		// ResponseEntity.status(HttpStatus.CREATED).body(turnoService.save(turno));
		return null;
	}

	// Leer turno

	@GetMapping("/{idTurno}")
	@ApiOperation(value = "Método que trae a un turno mediante su id")
	public ResponseEntity<Turno> getOne(@PathVariable(value = "idTurno") Integer idTurno) {
		// Valida si existe una persona con ese documento
		if (!turnoService.existsById(idTurno))
			return new ResponseEntity(new Mensaje("No existe un turno con ese ID"), HttpStatus.NOT_FOUND);
		Turno turno = turnoService.obtenerPorId(idTurno).get();
		return new ResponseEntity<Turno>(turno, HttpStatus.OK);
	}

	// actualizar turno
	@PutMapping("/{idTurno}")
	@ApiOperation(value = "Método que permite actualizar un turno")
	public ResponseEntity<?> update(@RequestBody Turno turnoDetails, @PathVariable(value = "idTurno") Integer idTurno) {
		Optional<Turno> turno = turnoService.findById(idTurno);
		if (!turno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		// BeanUtils.copyProperties(userDetails, user.get());
		/*
		 * turno.get().setName(userDetails.getName());
		 * turno.get().setLastname(userDetails.getLastname());
		 * turno.get().setEmail(userDetails.getEmail());
		 * turno.get().setEnabled(userDetails.getEnabled()); return
		 * ResponseEntity.status(HttpStatus.CREATED).body(turnoService.save(turno.get())
		 * );
		 */
		return null;
	}
	
	// Borrar turno
	@DeleteMapping("/{idTurno}")
	@ApiOperation(value = "Método que permite borrar un turno mediante su id")
	public ResponseEntity<?> delete(@PathVariable(value = "idTurno") Integer idTurno) {
		if (!turnoService.findById(idTurno).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		turnoService.deleteById(idTurno);
		return ResponseEntity.ok().build();
	}

	// Leer todos los turnos
	@GetMapping("/")
	@ApiOperation(value = "Método que trae la lista de todos los turnos registrados")
	public ResponseEntity<List<Turno>> getLista() {
		List<Turno> lista = turnoService.obtenerTodos();
		return new ResponseEntity<List<Turno>>(lista, HttpStatus.OK);
	}
}
