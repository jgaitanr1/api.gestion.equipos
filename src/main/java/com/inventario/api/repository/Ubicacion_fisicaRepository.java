package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Ubicacion_fisica;

public interface Ubicacion_fisicaRepository extends JpaRepository<Ubicacion_fisica, Integer> {
	
//	Optional<Ubicacion_fisica> findByCodigo(String codigo); 
	
	Optional<Ubicacion_fisica> findById(Long id);
	
	Optional<Ubicacion_fisica> findByNombre(String nombre);

}
