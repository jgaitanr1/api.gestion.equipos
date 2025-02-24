package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	
//	Optional<Marca> findByCodigo(String codigo); 
	
	Optional<Marca> findById(Long id);
	
	Optional<Marca> findByNombre(String nombre);

}
