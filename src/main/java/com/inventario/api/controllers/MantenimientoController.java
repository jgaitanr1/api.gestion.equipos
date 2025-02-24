package com.inventario.api.controllers;

import java.util.List;

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
import com.inventario.api.models.Mantenimiento;
import com.inventario.api.security.service.MantenimientoService;


@RestController
@RequestMapping("/api/mantenimiento")
@CrossOrigin("*")
public class MantenimientoController {

	@Autowired
	private MantenimientoService mantenimientoService;
	
	@PostMapping("/")
	public ResponseEntity<Mantenimiento> guardarMantenimiento(@RequestBody Mantenimiento mantenimiento){
		return ResponseEntity.ok(mantenimientoService.agregarMantenimiento(mantenimiento));
	}
	
	@PutMapping("/")
    public ResponseEntity<Mantenimiento> actualizarMantenimiento(@RequestBody Mantenimiento mantenimiento){
        return ResponseEntity.ok(mantenimientoService.actualizarMantenimiento(mantenimiento));
    }
	
	@GetMapping("/")
    public ResponseEntity<?> listarMantenimientos(){
        return ResponseEntity.ok(mantenimientoService.obtenerMantenimientos());
    }
	
	@GetMapping("/{mantenimientoId}")
    public Mantenimiento listarMantenimiento (@PathVariable("mantenimientoId") Integer mantenimientoId){
        return mantenimientoService.obtenerMantenimiento(mantenimientoId);
    }
	
	@DeleteMapping("/{mantenimientoId}")
    public void eliminarAdenda(@PathVariable("mantenimientoId") Integer mantenimientoId){
		mantenimientoService.eliminarMantenimiento(mantenimientoId);
    }
	
	@GetMapping("/equipo/{equipoId}")
    public List<Mantenimiento> listarMantenimientoDeEquipo(@PathVariable("equipoId") Integer equipoId){
		Equipo equipo = new Equipo();
		equipo.setId(equipoId);
        return mantenimientoService.listarMantenimientosdeEquipo(equipo);
    }
}
