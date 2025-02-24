package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Proveedor;
import com.inventario.api.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService{
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor actualizarProveedor (Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Set<Proveedor> obtenerProveedores() {
		return new LinkedHashSet<>(proveedorRepository.findAll());
	}

	@Override
	public Proveedor obtenerProveedor(Integer id) {
		return proveedorRepository.findById(id).get();
	}

//	@Override
//	public Proveedor obtenerProveedorCodigo(String proveedor) {
//		return proveedorRepository.findByCodigo(proveedor).get();
//	}

	@Override
	public void eliminarProveedor(Integer id) {
		Proveedor proveedor = new Proveedor();
		proveedor.setId(id);
		proveedorRepository.delete(proveedor);
		
	}

}
