package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Ubicacion_fisica;

public interface Ubicacion_fisicaService {
	
	Ubicacion_fisica agregarUbicacion_fisica(Ubicacion_fisica ubicacion_fisica);

	Ubicacion_fisica actualizarUbicacion_fisica(Ubicacion_fisica ubicacion_fisica);

    Set<Ubicacion_fisica> obtenerUbicacion_fisicas();

    Ubicacion_fisica obtenerUbicacion_fisica(Integer id);
    
//    Ubicacion_fisica obtenerUbicacion_fisicaCodigo(String codigo);

    void eliminarUbicacion_fisica(Integer id);

}
