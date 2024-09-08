package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Area;

public interface AreaService {
	
	Area agregarArea(Area area);

	Area actualizarArea(Area area);

    Set<Area> obtenerAreas();

    Area obtenerArea(Integer id);
    
//    Area obtenerAreaCodigo(String codigo);

    void eliminarArea(Integer id);

}
