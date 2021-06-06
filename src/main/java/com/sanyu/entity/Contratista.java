package com.sanyu.entity;

import java.util.List;

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
	@Column(name = "S_PASSWORD", nullable = false)
	private String password;
	@ManyToOne
	@JoinColumn(name = "K_IDTURNO", nullable = true)
	private Turno turno;
	@ManyToOne
	@JoinColumn(name = "K_IDROL", nullable = true,insertable=false, updatable=false)
	private Rol rol;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	

	
}
