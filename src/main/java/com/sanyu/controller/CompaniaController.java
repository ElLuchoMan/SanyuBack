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

import com.sanyu.DTO.Mensaje;
import com.sanyu.entity.Compania;
import com.sanyu.entity.Contratista;
import com.sanyu.service.CompaniaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/compania")
@CrossOrigin(origins = "*")
public class CompaniaController {
	@Autowired
	CompaniaService companiaService;
	@GetMapping("/")
	@ApiOperation(value = "M�todo que trae toda la informacion de la compania")
	public ResponseEntity<List<Compania>> getLista() {
		List<Compania> lista = companiaService.obtenerTodos();
		return new ResponseEntity<List<Compania>>(lista, HttpStatus.OK);
	}
}
