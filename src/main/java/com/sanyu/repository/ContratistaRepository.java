package com.sanyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Contratista;

import java.util.Optional;

@Repository
public interface ContratistaRepository extends JpaRepository<Contratista, Number> {
	Optional<Contratista> findByDocumento(Number documento);

	boolean existsByDocumento(Number documento);

	void deleteById(Number documento);


}
