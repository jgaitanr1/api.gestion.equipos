package com.inventario.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Evento;


public interface EventoRepository extends JpaRepository<Evento, Integer> {

	List<Evento> findByEquipo(Equipo equipo); 
	
	Optional<Evento> findById(Long id);
	
}
