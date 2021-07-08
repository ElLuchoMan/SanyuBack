package com.sanyu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sanyu.entity.Contratista;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratistaRepository extends JpaRepository<Contratista, Number> {
	Optional<Contratista> findByDocumento(Integer documento);

	boolean existsByDocumento(Integer documento);

	void deleteById(Number documento);

	@Query(value = "SELECT c.* FROM contratista c WHERE NOT EXISTS (SELECT * FROM turno_contratista t  WHERE t.k_documento = c.k_documento ) AND c.o_estadocontratista='Activo' AND c.k_idrol !=1", nativeQuery = true)
	public List<Contratista> contratistaSinTurno();

	@Query(value = "SELECT DISTINCT c.*,t.* FROM contratista c, turno t, turno_contratista tc where tc.k_documento = c.k_documento AND c.k_documento=:documento AND t.o_estado='Activo'", nativeQuery = true)

	public List<Contratista> findByContratista(@Param("documento") Integer documento);

	@Query(value = "SELECT c.* FROM contratista c WHERE c.k_documento =:documento AND c.s_password=:password", nativeQuery = true)
	public Optional<Contratista> findByLogin(@Param("documento") Integer documento, @Param("password") String password);
}
