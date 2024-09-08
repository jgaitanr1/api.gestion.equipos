package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Clase_equipo;

public interface Clase_equipoService {
	
	Clase_equipo agregarClase_equipo(Clase_equipo clase_equipo);

	Clase_equipo actualizarClase_equipo(Clase_equipo clase_equipo);

    Set<Clase_equipo> obtenerClase_equipos();

    Clase_equipo obtenerClase_equipo(Integer id);
    
//    Clase_equipo obtenerClase_equipoCodigo(String codigo);

    void eliminarClase_equipo(Integer id);

}
