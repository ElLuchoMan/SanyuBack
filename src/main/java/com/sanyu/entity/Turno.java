package com.sanyu.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Turno")
public class Turno {
	@Id
	@Column(name = "K_IDTURNO")
	private Integer idTurno;
	@Column(name = "F_FECHAINICIO")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@Column(name = "F_FECHAFIN")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	@Column(name = "H_HORAINICIO",nullable=false)
	private String horaInicio;
	@Column(name = "H_HORAFIN", nullable=false)
	private String horaFin;
	@Column(name = "O_OBSERVACION")
	private String observacion;
	@Column(name = "H_INICIOTURNO")
	private String inicioTurno;
	@Column(name = "H_FINTURNO")
	private String finTurno;
	@Column(name = "O_USUARIOMODIFICADOR")
	private String modificador;

	public String getInicioTurno() {
		return inicioTurno;
	}

	public void setInicioTurno(String inicioTurno) {
		this.inicioTurno = inicioTurno;
	}

	public String getFinTurno() {
		return finTurno;
	}

	public void setFinTurno(String finTurno) {
		this.finTurno = finTurno;
	}

	public String getModificador() {
		return modificador;
	}

	public void setModificador(String modificador) {
		this.modificador = modificador;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Integer getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
