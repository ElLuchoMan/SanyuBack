package com.sanyu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

//Clase que permite crear un objeto con documento y password para compararlo con la base de datos y permitir el login
public class Credenciales {
	@JsonProperty("documento")
	private Integer documento = null;

	@JsonProperty("password")
	private String password = null;

	public Credenciales(Integer documento, String password) {
		super();
		this.documento = documento;
		this.password = password;
	}

	public Credenciales() {

	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
