package com.sanyu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDROL")
	private Number idRol;

	@Column(name = "N_NOMBREROL", nullable = false, unique = true)
	private String nombreRol;
	// @ManyToOne
	// @JoinColumn(name = "K_IDTURNO", nullable = false)
	// private Turno turno;

}
