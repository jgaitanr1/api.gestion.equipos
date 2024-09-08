package com.inventario.api.security.service;

import java.util.List;
import java.util.Set;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Mantenimiento;

public interface MantenimientoService {

	Mantenimiento agregarMantenimiento(Mantenimiento mantenimiento);

	Mantenimiento actualizarMantenimiento(Mantenimiento mantenimiento);

	Set<Mantenimiento> obtenerMantenimientos();

	Mantenimiento obtenerMantenimiento(Integer mantenimientoId);

	void eliminarMantenimiento(Integer mantenimientoId);

	List<Mantenimiento> listarMantenimientosdeEquipo(Equipo equipo);
	
}
