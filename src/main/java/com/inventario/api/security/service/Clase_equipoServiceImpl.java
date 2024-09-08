package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Clase_equipo;
import com.inventario.api.repository.Clase_equipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Clase_equipoServiceImpl implements Clase_equipoService{

	@Autowired
	private Clase_equipoRepository clase_equipoRepository;
	
	@Override
	public Clase_equipo agregarClase_equipo(Clase_equipo clase_equipo) {
		return clase_equipoRepository.save(clase_equipo);
	}

	@Override
	public Clase_equipo actualizarClase_equipo(Clase_equipo clase_equipo) {
		return clase_equipoRepository.save(clase_equipo);
	}

	@Override
	public Set<Clase_equipo> obtenerClase_equipos() {
		return new LinkedHashSet<>(clase_equipoRepository.findAll());
	}

	@Override
	public Clase_equipo obtenerClase_equipo(Integer id) {
		return clase_equipoRepository.findById(id).get();
	}

//	@Override
//	public Clase_equipo obtenerClase_equipoCodigo(String codigo) {
//		return clase_equipoRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarClase_equipo(Integer id) {
		Clase_equipo clase_equipo = new Clase_equipo();
		clase_equipo.setId(id);
		clase_equipoRepository.delete(clase_equipo);
		
	}

}
