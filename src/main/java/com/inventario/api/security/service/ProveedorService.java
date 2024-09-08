package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.Proveedor;

public interface ProveedorService {

	Proveedor agregarProveedor(Proveedor sede);

	Proveedor actualizarProveedor(Proveedor sede);

    Set<Proveedor> obtenerProveedores();

    Proveedor obtenerProveedor(Integer id);
    
//    Proveedor obtenerProveedorCodigo(String codigo);

    void eliminarProveedor(Integer id);
    
}
