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
	@Autowired
	LoginService loginService;

	@PostMapping
	@ApiOperation(value = "Método para iniciar sesión")
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