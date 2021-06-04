package com.sanyu.entity;

import java.util.Date;
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

@Entity
@Table(name = "Turno")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDTURNO")
	private Number idTurno;
	@Column(name = "F_FECHAINICIO")
	private Date fechaInicio;
	@Column(name = "F_FECHAFIN")
	private Date fechaFin;
	@Column(name = "H_HORAINICIO")
	private String horaInicio;
	@Column(name = "O_OBSERVACION")
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "K_IDJORNADA", nullable = false)
	private Jornada jornada;	
	@OneToMany(mappedBy = "idRol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_IDROL", nullable = false)
	Set<Rol> rol;

}
