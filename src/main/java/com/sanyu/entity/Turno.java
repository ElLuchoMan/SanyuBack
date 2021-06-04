package com.sanyu.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Turno")
public class Turno {
	@Id
	@Column(name = "K_IDTURNO")
	private Integer idTurno;
	@Column(name = "F_FECHAINICIO")
	private Date fechaInicio;
	@Column(name = "F_FECHAFIN")
	private Date fechaFin;
	@Column(name = "H_HORAINICIO")
	private String horaInicio;
	@Column(name = "H_HORAFIN")
	private String horaFin;
	@Column(name = "O_OBSERVACION")
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "K_IDJORNADA", nullable = false)
	private Jornada jornada;
	@JsonIgnore
	@OneToMany(mappedBy = "idRol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_IDROL", nullable = false)
	Set<Rol> rol;

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

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Set<Rol> getRol() {
		return rol;
	}

	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

}
