package com.sanyu.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDROL")
	private Integer idRol;
	@Column(name = "N_NOMBREROL", nullable = false, unique = true)
	private String nombreRol;
	@JsonIgnore
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_DOCUMENTO", nullable = false)
	public Set<Contratista> contratista;
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
