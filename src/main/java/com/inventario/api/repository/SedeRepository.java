package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
	
//	Optional<Sede> findByCodigo(String codigo); 
	
	Optional<Sede> findById(Long id);
	
	Optional<Sede> findByNombre(String nombre);

}
