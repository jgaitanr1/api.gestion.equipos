package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Equipo;
import com.inventario.api.repository.EquipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService{
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Override
	public Equipo agregarEquipo(Equipo equipo) {
		return equipoRepository.save(equipo);
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		return equipoRepository.save(equipo);
	}

	@Override
	public Set<Equipo> obtenerEquipos() {
		return new LinkedHashSet<>(equipoRepository.findAll());
	}

	@Override
	public Equipo obtenerEquipo(Integer id) {
		return equipoRepository.findById(id).get();
	}

//	@Override
//	public Equipo obtenerEquipoCodigo(String codigo) {
//		return equipoRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarEquipo(Integer id) {
		Equipo equipo = new Equipo();
		equipo.setId(id);
		equipoRepository.delete(equipo);
		
	}
	
}
