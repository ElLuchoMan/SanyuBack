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
@Table(name = "TURNO_CONTRATISTA")
public class turnosContratista {
	@Id
	@Column(name = "K_DOCUMENTO")
	private Integer idRol;
	@Column(name = "F_FECHAINICIO")
	private Date fechaInicio;
	@Column(name = "F_FECHAFIN")
	private Date fechaFin;
	@Column(name = "O_USUARIOMODIFICADOR")
	private String modificador;
	@Column(name = "F_FECHAMODIFICACION")
	private Date fechaModificacion;
	@Column(name = "O_RAZONMODIFICACION")
	private String observacion;
	@Column(name = "H_INICIOTURNO")
	private String inicioTurno;
	@Column(name = "H_FINTURNO")
	private String finTurno;
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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
	public String getModificador() {
		return modificador;
	}
	public void setModificador(String modificador) {
		this.modificador = modificador;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
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
	
}
