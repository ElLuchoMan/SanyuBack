package com.sanyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jornada")
public class Jornada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDJORNADA")
	private Number idJornada;
	@Column(name = "N_NOMBREJORNADA")
	private String nombreJornada;

	public Number getIdJornada() {
		return idJornada;
	}

	public void setIdJornada(Number idJornada) {
		this.idJornada = idJornada;
	}

	public String getNombreJornada() {
		return nombreJornada;
	}

	public void setNombreJornada(String nombreJornada) {
		this.nombreJornada = nombreJornada;
	}

}
