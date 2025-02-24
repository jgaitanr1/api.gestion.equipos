package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Clase_equipo;

public interface Clase_equipoRepository extends JpaRepository<Clase_equipo, Integer> {
	
//	Optional<Clase_equipo> findByCodigo(String codigo); 
	
	Optional<Clase_equipo> findById(Long id);
	
	Optional<Clase_equipo> findByNombre(String nombre);

}
