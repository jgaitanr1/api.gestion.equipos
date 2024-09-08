package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Servicio;

public interface ServicioService {
	
	Servicio agregarServicio(Servicio servicio);

	Servicio actualizarServicio(Servicio servicio);

    Set<Servicio> obtenerServicios();

    Servicio obtenerServicio(Integer id);
    
//    Servicio obtenerServicioCodigo(String codigo);

    void eliminarServicio(Integer id);

}
