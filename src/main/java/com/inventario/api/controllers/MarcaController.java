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

import com.inventario.api.models.Marca;
import com.inventario.api.security.service.MarcaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/marca")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/")
	public ResponseEntity<Marca> guardarMarca(@RequestBody Marca marca) {
		Marca marcaGuardada = marcaService.agregarMarca(marca);
		return ResponseEntity.ok(marcaGuardada);
	}
	
	@GetMapping("/{marcaId}")
	public Marca listarMarcaPorId(@PathVariable("marcaId") Integer marcaId) {
		return marcaService.obtenerMarca(marcaId);
	}
	
//	@GetMapping("/{codigo}")
//	public Marca listarMarcaPorCodigo(@PathVariable("codigo") String codigo) {
//		return marcaService.obtenerMarcaCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarMarcas() {
		return ResponseEntity.ok(marcaService.obtenerMarcas());
	}
	
	@PutMapping("/")
	public Marca actualizarMarca(@RequestBody Marca marca) {
		return marcaService.actualizarMarca(marca);
	}

	@DeleteMapping("/{marcaId}")
	public void eliminarMarca(@PathVariable("marcaId") Integer marcaId) {
		marcaService.eliminarMarca(marcaId);
	}

}
