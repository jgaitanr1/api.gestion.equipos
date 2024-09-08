package com.inventario.api.security.service;

import java.util.List;
import java.util.Set;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Evento;

public interface EventoService {

	Evento agregarEvento(Evento evento);

	Evento actualizarEvento(Evento evento);

	Set<Evento> obtenerEventos();

	Evento obtenerEvento(Integer eventoId);

	void eliminarEvento(Integer eventoId);

	List<Evento> listarEventosdeEquipo(Equipo equipo);
	
}
