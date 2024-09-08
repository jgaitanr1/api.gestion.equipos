package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	
//	Optional<Servicio> findByCodigo(String codigo); 
	
	Optional<Servicio> findById(Long id);
	
	Optional<Servicio> findByNombre(String nombre);

}
