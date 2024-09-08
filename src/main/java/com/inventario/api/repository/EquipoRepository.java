package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Equipo;


public interface EquipoRepository extends JpaRepository<Equipo, Integer>{

//	Optional<Equipo> findByCodigo(String codigo); 
	
	Optional<Equipo> findById(Long id);
	
//	Optional<Equipo> findByNombre(String nombre);
	
}
