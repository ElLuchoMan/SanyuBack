package com.sanyu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//Clase que permite crear un objeto de respuesta cuando el usuario ha logueado correctamente
public class UsuarioLogeado {
	@JsonProperty("documento")
	private Integer documento = null;
	@JsonProperty("nombre")
	private String nombre = null;
	@JsonProperty("rol")
	private Rol rol = null;
	@JsonProperty("estadoContratista")
	private String estadoContratista = null;

	public UsuarioLogeado(Integer documento, String nombre, Rol rol, String estadoContratista) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.rol = rol;
		this.estadoContratista = estadoContratista;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getEstadoContratista() {
		return estadoContratista;
	}

	public void setEstadoContratista(String estadoContratista) {
		this.estadoContratista = estadoContratista;
	}

}
