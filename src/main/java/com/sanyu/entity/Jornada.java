package com.sanyu.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jornada")
public class Jornada {
	@Id
	@Column(name = "K_IDJORNADA")
	private Number idJornada;
	@Column(name = "N_NOMBREJORNADA")
	private String nombreJornada;
	@OneToMany(mappedBy = "idTurno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_IDTURNO", nullable = false)
	Set<Turno> turno;

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

	public Set<Turno> getTurno() {
		return turno;
	}

	public void setTurno(Set<Turno> turno) {
		this.turno = turno;
	}

}
