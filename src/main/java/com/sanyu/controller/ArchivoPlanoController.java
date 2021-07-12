package com.sanyu.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sanyu.service.ArchivoPlanoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/turnosMasivos")
@CrossOrigin(origins = "*")
public class ArchivoPlanoController {
	@Autowired
	private ArchivoPlanoService archivoSevice;
	@PostMapping
	@ApiOperation(value = "M�todo que permite carga masiva de turnos")
	public ResponseEntity<?> cargar(@RequestParam("turnos") MultipartFile archivo) {
		try {
			archivoSevice.subirArchivo(archivoSevice.guardar(archivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().build();
	}
}
