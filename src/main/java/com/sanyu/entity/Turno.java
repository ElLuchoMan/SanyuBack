package com.sanyu.entity;

import java.util.Date;
import java.util.List;

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
	private Date fechaInicio;
	@Column(name = "F_FECHAFIN")
	private Date fechaFin;
	@Column(name = "H_HORAINICIO", nullable = false)
	private String horaInicio;
	@Column(name = "H_HORAFIN", nullable = false)
	private String horaFin;
	@Column(name = "O_USUARIOMODIFICADOR")
	private String modificador;
	@Column(name = "F_FECHAMODIFICACION")
	private Date fechaModificacion;
	@Column(name = "O_RAZONMODFICIACION")
	private String observacion;
	@Column(name = "H_INICIOTURNO")
	private String inicioTurno;
	@Column(name = "H_FINTURNO")
	private String finTurno;
	

	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, fetch
	 * =FetchType.LAZY) // @Column(name = "K_DOCUMENTO", nullable = false) public
	 * List<Contratista> contratista;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "K_IDJORNADA", nullable = false, insertable = false,
	 * updatable = false) private Jornada jornada;
	 */

}
