package com.sanyu.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROL")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDROL")
	private Integer idRol;
	@Column(name = "N_NOMBREROL", nullable = false, unique = true)
	private String nombreRol;
	@Column(name = "O_ESTADOROL", nullable = false, unique = true)
	private String estadoRol;
	@JsonIgnore
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_DOCUMENTO", nullable = false)
	Set<Contratista> contratista;

	public String getEstadoRol() {
		return estadoRol;
	}

	public void setEstadoRol(String estadoRol) {
		this.estadoRol = estadoRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public Set<Contratista> getContratista() {
		return contratista;
	}

	public void setContratista(Set<Contratista> contratista) {
		this.contratista = contratista;
	}

}
