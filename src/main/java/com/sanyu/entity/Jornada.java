package com.sanyu.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "idTurno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_IDTURNO", nullable = false)
	Set<Turno> turno;


}
