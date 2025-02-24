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
import com.inventario.api.models.Evento;
import com.inventario.api.security.service.EventoService;


@RestController
@RequestMapping("/api/evento")
@CrossOrigin("*")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@PostMapping("/")
	public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento){
		return ResponseEntity.ok(eventoService.agregarEvento(evento));
	}
	
	@PutMapping("/")
    public ResponseEntity<Evento> actualizarEvento(@RequestBody Evento evento){
        return ResponseEntity.ok(eventoService.actualizarEvento(evento));
    }
	
	@GetMapping("/")
    public ResponseEntity<?> listarEventos(){
        return ResponseEntity.ok(eventoService.obtenerEventos());
    }
	
	@GetMapping("/{eventoId}")
    public Evento listarEvento (@PathVariable("eventoId") Integer eventoId){
        return eventoService.obtenerEvento(eventoId);
    }
	
	@DeleteMapping("/{eventoId}")
    public void eliminarAdenda(@PathVariable("eventoId") Integer eventoId){
		eventoService.eliminarEvento(eventoId);
    }
	
	@GetMapping("/equipo/{equipoId}")
    public List<Evento> listarEventoDeEquipo(@PathVariable("equipoId") Integer equipoId){
		Equipo equipo = new Equipo();
		equipo.setId(equipoId);
        return eventoService.listarEventosdeEquipo(equipo);
    }
}
