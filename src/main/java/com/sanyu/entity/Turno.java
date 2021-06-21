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
