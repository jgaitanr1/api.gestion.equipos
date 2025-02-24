package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Mantenimiento;
import com.inventario.api.repository.MantenimientoRepository;

@Service
public class MantenimientoServiceImpl implements MantenimientoService{
	
	@Autowired
	private MantenimientoRepository mantenimientoRepository;
	
	@Override
	public Mantenimiento agregarMantenimiento(Mantenimiento mantenimiento) {
		return mantenimientoRepository.save(mantenimiento);
	}

	@Override
	public Mantenimiento actualizarMantenimiento(Mantenimiento mantenimiento) {
		return mantenimientoRepository.save(mantenimiento);
	}

	@Override
	public Set<Mantenimiento> obtenerMantenimientos() {
		return new LinkedHashSet<>(mantenimientoRepository.findAll());
	}

	@Override
	public Mantenimiento obtenerMantenimiento(Integer mantenimientoId) {
		return mantenimientoRepository.findById(mantenimientoId).get();
	}

	@Override
	public void eliminarMantenimiento(Integer mantenimientoId) {
		Mantenimiento mantenimiento = new Mantenimiento();
		mantenimiento.setId(mantenimientoId);
		mantenimientoRepository.delete(mantenimiento);
	}

	@Override
	public List<Mantenimiento> listarMantenimientosdeEquipo(Equipo equipo) {
		return this.mantenimientoRepository.findByEquipo(equipo);
	}


}
