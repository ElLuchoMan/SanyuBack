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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "K_IDROL")
	private Number idRol;

	@Column(name = "N_NOMBREROL", nullable = false, unique = true)
	private String nombreRol;
	// @ManyToOne
	// @JoinColumn(name = "K_IDTURNO", nullable = false)
	// private Turno turno;
	@JsonIgnore
	@OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "K_DOCUMENTO", nullable = false)
	Set<Contratista> contratista;

}
