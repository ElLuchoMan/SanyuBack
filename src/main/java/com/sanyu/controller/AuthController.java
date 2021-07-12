package com.sanyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanyu.entity.Credenciales;
import com.sanyu.entity.UsuarioLogeado;
import com.sanyu.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
	// Servicio a utilizar
	@Autowired
	LoginService loginService;

	// M�todo para comparar informaci�n de inicio de sesi�n traida en el Body con la
	// informaci�n almacenada en DB
	@PostMapping
	@ApiOperation(value = "M�todo para iniciar sesi�n")
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