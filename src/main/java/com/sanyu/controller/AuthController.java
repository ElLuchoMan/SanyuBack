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

import com.sanyu.DTO.Mensaje;
import com.sanyu.entity.Contratista;
import com.sanyu.entity.Credenciales;
import com.sanyu.entity.UsuarioLogeado;
import com.sanyu.service.ContratistaService;
import com.sanyu.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
	ContratistaService contratistaService;
	@Autowired
	LoginService loginService;

	@GetMapping("documento={documento}&password={password}")
	@ApiOperation(value = "Método para iniciar sesión")
	public ResponseEntity<Contratista> Login(@PathVariable Integer documento, String password) {
		// Valida si existe una persona con ese documento
		if (!contratistaService.existsByDocumento(documento))
			return new ResponseEntity(new Mensaje("No existe una persona con ese documento"), HttpStatus.NOT_FOUND);
		Contratista contratista = contratistaService.findByLogin(documento, password).get();

		return new ResponseEntity<Contratista>(contratista, HttpStatus.OK);
	}

	@PostMapping
	public UsuarioLogeado Login(@RequestBody Credenciales credenciales) {
		try {
			if (credenciales != null) {
				if (credenciales.getDocumento() != null && !credenciales.getPassword().isBlank()) {
					return loginService.comprobar(credenciales);
				}
			}
		} catch (Exception ex) {

		}
		return null;
	}
}