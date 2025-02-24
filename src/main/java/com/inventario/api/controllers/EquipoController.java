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

import com.inventario.api.models.Equipo;
import com.inventario.api.security.service.EquipoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/equipo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EquipoController {

	@Autowired
	private EquipoService equipoService;
	
	@PostMapping("/")
	public ResponseEntity<Equipo> guardarSede(@RequestBody Equipo equipo) {
		Equipo equipoGuardada = equipoService.agregarEquipo(equipo);
		return ResponseEntity.ok(equipoGuardada);
	}
	
	@GetMapping("/{equipoId}")
	public Equipo listarEquipoPorId(@PathVariable("equipoId") Integer equipoId) {
		return equipoService.obtenerEquipo(equipoId);
	}
	
//	@GetMapping("/{codigo}")
//	public Equipo listarEquipoPorCodigo(@PathVariable("codigo") String codigo) {
//		return equipoService.obtenerEquipoCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarEquipos() {
		return ResponseEntity.ok(equipoService.obtenerEquipos());
	}
	
	@PutMapping("/")
	public Equipo actualizarEquipo(@RequestBody Equipo equipo) {
		return equipoService.actualizarEquipo(equipo);
	}

	@DeleteMapping("/{equipoId}")
	public void eliminarEquipo(@PathVariable("equipoId") Integer equipoId) {
		equipoService.eliminarEquipo(equipoId);
	}
	
}
