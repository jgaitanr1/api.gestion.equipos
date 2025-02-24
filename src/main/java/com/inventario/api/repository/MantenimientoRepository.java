package com.inventario.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Mantenimiento;


public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

	List<Mantenimiento> findByEquipo(Equipo equipo); 
	
	Optional<Mantenimiento> findById(Long id);
	
}
