package com.sanyu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	// @JsonIgnore
	@JoinTable(name = "TURNO_CONTRATISTA", joinColumns = @JoinColumn(name = "FK_TURNO_CONTRATISTA", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_CONTRATISTA_TURNO", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Turno> turnos;
	@ManyToOne
	@JoinColumn(name = "K_IDROL")
	private Rol rol;

	public Contratista(Integer documento, String nombre, String telefono, String password) {
		this.documento = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.password = password;
	}

	public void agregarTurnos(Turno turno) {
		if (this.turnos == null) {
			this.turnos = new ArrayList<>();
		}
		this.turnos.add(turno);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
