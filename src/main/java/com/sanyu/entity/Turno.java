package com.sanyu.entity;

import java.time.LocalDateTime;
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
@Table(name = "Turno")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDTURNO")
	private Integer idTurno;
	@Column(name = "F_FECHAINICIO")
	private LocalDateTime fechaInicio;
	@Column(name = "F_FECHAFIN")
	private LocalDateTime fechaFin;
	@Column(name = "H_HORAINICIO", nullable = false)
	private String horaInicio;
	@Column(name = "H_HORAFIN", nullable = false)
	private String horaFin;
	@Column(name = "O_OBSERVACION")
	private String observacion;
	@Column(name = "H_INICIOTURNO")
	private String inicioTurno;
	@Column(name = "H_FINTURNO")
	private String finTurno;
	@Column(name = "O_USUARIOMODIFICADOR")
	private String modificador;
	@Column(name = "F_FECHAMODIFICACION")
	private LocalDateTime fechaModificacion;
	@JsonIgnore
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_DOCUMENTO", nullable = false)
	public List<Contratista> contratista;
	@ManyToOne
	@JoinColumn(name = "K_IDJORNADA", nullable = false,insertable=false, updatable=false)
	private Jornada jornada;
	public Integer getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
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
	public String getModificador() {
		return modificador;
	}
	public void setModificador(String modificador) {
		this.modificador = modificador;
	}
	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public List<Contratista> getContratista() {
		return contratista;
	}
	public void setContratista(List<Contratista> contratista) {
		this.contratista = contratista;
	}
	public Jornada getJornada() {
		return jornada;
	}
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}
	
	

}
