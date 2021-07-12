package com.sanyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIA")
public class Compania {
	@Id
	@Column(name = "K_NITCOMPANIA")
	private Integer nitCompania;
	@Column(name = "N_RAZONSOCIAL", nullable = false, unique = true)
	private String razonSocial;
	@Column(name = "O_TELEFONO", nullable = false, unique = true)
	private String telefonoCompania;
	@Column(name = "O_DIRECCION", nullable = false, unique = true)
	private String direccion;

	public Integer getNitCompania() {
		return nitCompania;
	}

	public void setNitCompania(Integer nitCompania) {
		this.nitCompania = nitCompania;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefonoCompania() {
		return telefonoCompania;
	}

	public void setTelefonoCompania(String telefonoCompania) {
		this.telefonoCompania = telefonoCompania;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
