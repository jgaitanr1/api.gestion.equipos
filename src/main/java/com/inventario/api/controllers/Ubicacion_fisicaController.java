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

import com.inventario.api.models.Ubicacion_fisica;
import com.inventario.api.security.service.Ubicacion_fisicaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ubicacion_fisica")
@RequiredArgsConstructor
@CrossOrigin("*")
public class Ubicacion_fisicaController {
	
	@Autowired
	private Ubicacion_fisicaService ubicacion_fisicaService;
	
	@PostMapping("/")
	public ResponseEntity<Ubicacion_fisica> guardarUbicacion_fisica(@RequestBody Ubicacion_fisica ubicacion_fisica) {
		Ubicacion_fisica ubicacion_fisicaGuardada = ubicacion_fisicaService.agregarUbicacion_fisica(ubicacion_fisica);
		return ResponseEntity.ok(ubicacion_fisicaGuardada);
	}
	
	@GetMapping("/{ubicacion_fisicaId}")
	public Ubicacion_fisica listarUbicacion_fisicaPorId(@PathVariable("ubicacion_fisicaId") Integer ubicacion_fisicaId) {
		return ubicacion_fisicaService.obtenerUbicacion_fisica(ubicacion_fisicaId);
	}
	
//	@GetMapping("/{codigo}")
//	public Ubicacion_fisica listarUbicacion_fisicaPorCodigo(@PathVariable("codigo") String codigo) {
//		return ubicacion_fisicaService.obtenerUbicacion_fisicaCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarUbicacion_fisicas() {
		return ResponseEntity.ok(ubicacion_fisicaService.obtenerUbicacion_fisicas());
	}
	
	@PutMapping("/")
	public Ubicacion_fisica actualizarUbicacion_fisica(@RequestBody Ubicacion_fisica ubicacion_fisica) {
		return ubicacion_fisicaService.actualizarUbicacion_fisica(ubicacion_fisica);
	}

	@DeleteMapping("/{ubicacion_fisicaId}")
	public void eliminarUbicacion_fisica(@PathVariable("ubicacion_fisicaId") Integer ubicacion_fisicaId) {
		ubicacion_fisicaService.eliminarUbicacion_fisica(ubicacion_fisicaId);
	}

}
