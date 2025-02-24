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

import com.inventario.api.models.Servicio;
import com.inventario.api.security.service.ServicioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicio")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@PostMapping("/")
	public ResponseEntity<Servicio> guardarServicio(@RequestBody Servicio servicio) {
		Servicio servicioGuardada = servicioService.agregarServicio(servicio);
		return ResponseEntity.ok(servicioGuardada);
	}
	
	@GetMapping("/{servicioId}")
	public Servicio listarServicioPorId(@PathVariable("servicioId") Integer servicioId) {
		return servicioService.obtenerServicio(servicioId);
	}
	
//	@GetMapping("/{codigo}")
//	public Servicio listarServicioPorCodigo(@PathVariable("codigo") String codigo) {
//		return servicioService.obtenerServicioCodigo(codigo);
//	}

	@GetMapping("/")
	public ResponseEntity<?> listarServicios() {
		return ResponseEntity.ok(servicioService.obtenerServicios());
	}
	
	@PutMapping("/")
	public Servicio actualizarServicio(@RequestBody Servicio servicio) {
		return servicioService.actualizarServicio(servicio);
	}

	@DeleteMapping("/{servicioId}")
	public void eliminarServicio(@PathVariable("servicioId") Integer servicioId) {
		servicioService.eliminarServicio(servicioId);
	}

}
