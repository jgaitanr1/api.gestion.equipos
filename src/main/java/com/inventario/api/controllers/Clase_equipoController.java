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

import com.inventario.api.models.Clase_equipo;
import com.inventario.api.security.service.Clase_equipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clase_equipo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class Clase_equipoController {
	
	@Autowired
	private Clase_equipoService clase_equipoService;
	
	@PostMapping("/")
	public ResponseEntity<Clase_equipo> guardarClase_equipo(@RequestBody Clase_equipo clase_equipo) {
		Clase_equipo clase_equipoGuardada = clase_equipoService.agregarClase_equipo(clase_equipo);
		return ResponseEntity.ok(clase_equipoGuardada);
	}
	
	@GetMapping("/{clase_equipoId}")
	public Clase_equipo listarClase_equipoPorId(@PathVariable("clase_equipoId") Integer clase_equipoId) {
		return clase_equipoService.obtenerClase_equipo(clase_equipoId);
	}
	
//	@GetMapping("/{codigo}")
//	public Clase_equipo listarClase_equipoPorCodigo(@PathVariable("codigo") String codigo) {
//		return clase_equipoService.obtenerClase_equipoCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarClase_equipos() {
		return ResponseEntity.ok(clase_equipoService.obtenerClase_equipos());
	}
	
	@PutMapping("/")
	public Clase_equipo actualizarClase_equipo(@RequestBody Clase_equipo clase_equipo) {
		return clase_equipoService.actualizarClase_equipo(clase_equipo);
	}

	@DeleteMapping("/{clase_equipoId}")
	public void eliminarClase_equipo(@PathVariable("clase_equipoId") Integer clase_equipoId) {
		clase_equipoService.eliminarClase_equipo(clase_equipoId);
	}

}
