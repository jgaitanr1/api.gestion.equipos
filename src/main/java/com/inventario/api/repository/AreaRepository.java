package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	
//	Optional<Area> findByCodigo(String codigo); 
	
	Optional<Area> findById(Long id);
	
	Optional<Area> findByNombre(String nombre);

}
