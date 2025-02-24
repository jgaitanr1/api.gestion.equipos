package com.inventario.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
	
//	Optional<Proveedor> findByCodigo(String codigo); 
	
	Optional<Proveedor> findById(Long id);
	
	Optional<Proveedor> findByNombre(String nombre);

}
