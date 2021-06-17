package com.sanyu.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TURNO")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDTURNO")
	private Integer idTurno;

	@Column(name = "H_HORAINICIO", nullable = false)
	private String horaInicio;
	@Column(name = "H_HORAFIN", nullable = false)
	private String horaFin;
	@JsonIgnore
	@ManyToMany(mappedBy = "turnos")
	private List<Contratista> contratistas;
	@ManyToOne
	@JoinColumn(name = "K_IDJORNADA")
	private Jornada jornada;

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public List<Contratista> getContratistas() {
		return contratistas;
	}

	public void setContratistas(List<Contratista> contratistas) {
		this.contratistas = contratistas;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

}
