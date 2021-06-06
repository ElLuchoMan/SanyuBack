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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Jornada")
public class Jornada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDJORNADA")
	private Integer idJornada;
	@Column(name = "N_NOMBREJORNADA")
	private String nombreJornada;
	@JsonIgnore
	@OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_IDTURNO", nullable = false)
	public List<Contratista> contratista;
	public Integer getIdJornada() {
		return idJornada;
	}
	public void setIdJornada(Integer idJornada) {
		this.idJornada = idJornada;
	}
	public String getNombreJornada() {
		return nombreJornada;
	}
	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}
	public List<Contratista> getContratista() {
		return contratista;
	}
	public void setContratista(List<Contratista> contratista) {
		this.contratista = contratista;
	}

}
