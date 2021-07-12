package com.sanyu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Compania;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Integer> {
	// Método para encontrar una compania mediante su NIT
	Optional<Compania> findById(Integer nitCompania);
}
