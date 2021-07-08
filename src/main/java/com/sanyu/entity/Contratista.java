package com.sanyu.entity;

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
@Table(name = "CONTRATISTA")
public class Contratista {

	@Id
	@Column(name = "K_DOCUMENTO")
	private Integer documento;
	@Column(name = "S_PASSWORD", nullable = false)
	private String password;
	@Column(name = "N_NOMBRECONTRATISTA", nullable = false, length = 50)
	private String nombre;
	@Column(name = "O_TELEFONO", nullable = false, unique = true)
	private String telefono;
	@Column(name = "O_ESTADOCONTRATISTA", nullable = false, unique = true)
	private String estadoContratista;
	@ManyToOne
	@JoinColumn(name = "K_IDROL")
	public Rol rol;
	// @JsonIgnore
	@JoinTable(name = "TURNO_CONTRATISTA", joinColumns = @JoinColumn(name = "K_DOCUMENTO", nullable = true), inverseJoinColumns = @JoinColumn(name = "K_IDTURNO", nullable = true))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Turno> turnos;

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

	public String getEstadoContratista() {
		return estadoContratista;
	}

	public void setEstadoContratista(String estadoContratista) {
		this.estadoContratista = estadoContratista;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

}
