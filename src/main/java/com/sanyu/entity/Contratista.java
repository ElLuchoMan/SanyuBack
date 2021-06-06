package com.sanyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contratista")
public class Contratista {

	@Id
	@Column(name = "K_DOCUMENTO")
	private Integer documento;

	@Column(name = "N_NOMBRECONTRATISTA", nullable = false, length = 50)
	private String nombre;

	@Column(name = "O_TELEFONO", nullable = false, unique = true)
	private String telefono;
	@Column(name="S_PASSWORD",nullable=false)
	private String password;
	//@ManyToOne
	//@JoinColumn(name = "K_IDROL", nullable = false)
	//private Rol rol;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



}
