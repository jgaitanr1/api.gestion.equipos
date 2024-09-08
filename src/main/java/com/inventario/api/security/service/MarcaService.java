package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Marca;

public interface MarcaService {
	
	Marca agregarMarca(Marca marca);

	Marca actualizarMarca(Marca marca);

    Set<Marca> obtenerMarcas();

    Marca obtenerMarca(Integer id);
    
//    Marca obtenerMarcaCodigo(String codigo);

    void eliminarMarca(Integer id);

}
