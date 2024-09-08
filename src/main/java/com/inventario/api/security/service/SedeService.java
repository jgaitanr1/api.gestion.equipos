package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Sede;

public interface SedeService {
	
	Sede agregarSede(Sede sede);

	Sede actualizarSede(Sede sede);

    Set<Sede> obtenerSedes();

    Sede obtenerSede(Integer id);
    
//    Sede obtenerSedeCodigo(String codigo);

    void eliminarSede(Integer id);

}
