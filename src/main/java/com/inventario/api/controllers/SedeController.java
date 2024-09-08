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

import com.inventario.api.models.Sede;
import com.inventario.api.security.service.SedeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sede")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SedeController {
	
	@Autowired
	private SedeService sedeService;
	
	@PostMapping("/")
	public ResponseEntity<Sede> guardarSede(@RequestBody Sede sede) {
		Sede sedeGuardada = sedeService.agregarSede(sede);
		return ResponseEntity.ok(sedeGuardada);
	}
	
	@GetMapping("/{sedeId}")
	public Sede listarSedePorId(@PathVariable("sedeId") Integer sedeId) {
		return sedeService.obtenerSede(sedeId);
	}
	
//	@GetMapping("/{codigo}")
//	public Sede listarSedePorCodigo(@PathVariable("codigo") String codigo) {
//		return sedeService.obtenerSedeCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarSedes() {
		return ResponseEntity.ok(sedeService.obtenerSedes());
	}
	
	@PutMapping("/")
	public Sede actualizarSede(@RequestBody Sede sede) {
		return sedeService.actualizarSede(sede);
	}

	@DeleteMapping("/{sedeId}")
	public void eliminarSede(@PathVariable("sedeId") Integer sedeId) {
		sedeService.eliminarSede(sedeId);
	}

}
