package com.inventario.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventario.api.models.Proveedor;
import com.inventario.api.security.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping("/")
	public ResponseEntity<Proveedor> guardarProveedor(@RequestBody Proveedor proveedor) {
		Proveedor proveedorGuardada = proveedorService.agregarProveedor(proveedor);
		return ResponseEntity.ok(proveedorGuardada);
	}
	
	@GetMapping("/{proveedorId}")
	public Proveedor listarProveedorPorId(@PathVariable("proveedorId") Integer proveedorId) {
		return proveedorService.obtenerProveedor(proveedorId);
	}
	
//	@GetMapping("/{codigo}")
//	public Proveedor listarProveedorPorCodigo(@PathVariable("codigo") String codigo) {
//		return proveedorService.obtenerProveedorCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarProveedores() {
		return ResponseEntity.ok(proveedorService.obtenerProveedores());
	}
	
	@PutMapping("/")
	public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorService.actualizarProveedor(proveedor);
	}

	@DeleteMapping("/{proveedorId}")
	public void eliminarProveedor(@PathVariable("proveedorId") Integer proveedorId) {
		proveedorService.eliminarProveedor(proveedorId);
	}
}
