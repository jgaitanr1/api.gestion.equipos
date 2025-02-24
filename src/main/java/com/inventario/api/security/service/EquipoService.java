package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Equipo;

public interface EquipoService {

	Equipo agregarEquipo(Equipo equipo);

	Equipo actualizarEquipo(Equipo equipo);

    Set<Equipo> obtenerEquipos();

    Equipo obtenerEquipo(Integer id);
    
  //  Equipo obtenerEquipoCodigo(String codigo);

    void eliminarEquipo(Integer id);
}
