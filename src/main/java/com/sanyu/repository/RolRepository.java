package com.sanyu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	Optional<Rol> findById(Integer idRol);

	Optional<Rol> findByNombreRol(String nombreRol);
}
