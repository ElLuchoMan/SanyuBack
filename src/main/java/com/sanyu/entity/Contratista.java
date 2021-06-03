package com.sanyu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Contratista")
public class Contratista implements Serializable {

	private static final long serialVersionUID = 9015649773260182798L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="K_DOCUMENTO")
private Number documento;

@Column(name="N_NOMBRECONTRATISTA", nullable=false, length=50)
private String nombre;

@Column(name="Q_TELEFONO", nullable=false,unique=true)
private String telefono;
//@ManyToOne
//@JoinColumn(name = "K_IDROL", nullable = false)
//private Rol rol;


}
