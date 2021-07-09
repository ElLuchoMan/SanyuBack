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
		turnoService.guardar(turno);
		return new ResponseEntity(new Mensaje("turno creado"), HttpStatus.CREATED);
	}

	// Leer turno

	@GetMapping("/{idTurno}")
	@ApiOperation(value = "Método que trae a un turno mediante su id")
	public ResponseEntity<Turno> getOne(@PathVariable(value = "idTurno") Integer idTurno) {
		// Valida si existe una persona con ese documento
		if (!turnoService.existsByIdTurno(idTurno))
			return new ResponseEntity(new Mensaje("No existe un turno con ese ID"), HttpStatus.NOT_FOUND);
		Turno turno = turnoService.obtenerPorId(idTurno).get();
		return new ResponseEntity<Turno>(turno, HttpStatus.OK);
	}

	// actualizar turno
	@PutMapping("/actualizar/{idTurno}")
	@ApiOperation(value = "Método que permite actualizar un turno mediante su id")
	public ResponseEntity<?> update(@RequestBody Turno turno, @PathVariable("idTurno") Integer idTurno) {
		if (!turnoService.existsByIdTurno(idTurno))
			return new ResponseEntity(new Mensaje("No existe ese turno"), HttpStatus.NOT_FOUND);
		Turno turnoDetails = turnoService.obtenerPorId(idTurno).get();
		turnoDetails.setEstadoTurno(turno.getEstadoTurno());
		turnoDetails.setFinTurno(turno.getFinTurno());
		turnoDetails.setHoraFin(turno.getHoraFin());
		turnoDetails.setHoraInicio(turno.getHoraInicio());
		turnoDetails.setIdTurno(turno.getIdTurno());
		turnoDetails.setInicioTurno(turno.getInicioTurno());
		turnoDetails.setLabor(turno.getLabor());
		turnoDetails.setFechaModificacion(turno.getFechaModificacion());
		turnoDetails.setModificador(turno.getModificador());
		turnoDetails.setObservacion(turno.getObservacion());
		turnoService.guardar(turnoDetails);
		return new ResponseEntity(new Mensaje("Turno actualizado"), HttpStatus.CREATED);
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

	// Cargar los turnos de un contratista
	@GetMapping("/turno/{documento}")
	@ApiOperation(value = "Método que trae los turnos de un contratista mediante su documento")
	public ResponseEntity<List<Turno>> getTurnoContratista(@PathVariable Integer documento) {
		List<Turno> contratista = turnoService.findByContratista(documento);
		return new ResponseEntity<List<Turno>>(contratista, HttpStatus.OK);
	}
	@GetMapping("/turnoHoy/{documento}")
	@ApiOperation(value = "Método que trae el turno del día para un contratista mediante su documento")
	public ResponseEntity<Turno> getTurnoHoyContratista(@PathVariable Integer documento) {
		Turno contratista = turnoService.findByTurno(documento);
		return new ResponseEntity<Turno>(contratista, HttpStatus.OK);
	}
}
