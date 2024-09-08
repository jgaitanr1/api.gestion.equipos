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

import com.inventario.api.models.Area;
import com.inventario.api.security.service.AreaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/area")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@PostMapping("/")
	public ResponseEntity<Area> guardarArea(@RequestBody Area area) {
		Area areaGuardada = areaService.agregarArea(area);
		return ResponseEntity.ok(areaGuardada);
	}
	
	@GetMapping("/{areaId}")
	public Area listarAreaPorId(@PathVariable("areaId") Integer areaId) {
		return areaService.obtenerArea(areaId);
	}
	
//	@GetMapping("/{codigo}")
//	public Area listarAreaPorCodigo(@PathVariable("codigo") String codigo) {
//		return areaService.obtenerAreaCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarAreas() {
		return ResponseEntity.ok(areaService.obtenerAreas());
	}
	
	@PutMapping("/")
	public Area actualizarArea(@RequestBody Area area) {
		return areaService.actualizarArea(area);
	}

	@DeleteMapping("/{areaId}")
	public void eliminarArea(@PathVariable("areaId") Integer areaId) {
		areaService.eliminarArea(areaId);
	}

}
