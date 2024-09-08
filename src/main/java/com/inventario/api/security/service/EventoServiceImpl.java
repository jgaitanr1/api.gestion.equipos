package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Equipo;
import com.inventario.api.models.Evento;
import com.inventario.api.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService{
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	public Evento agregarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Evento actualizarEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Set<Evento> obtenerEventos() {
		return new LinkedHashSet<>(eventoRepository.findAll());
	}

	@Override
	public Evento obtenerEvento(Integer eventoId) {
		return eventoRepository.findById(eventoId).get();
	}

	@Override
	public void eliminarEvento(Integer eventoId) {
		Evento evento = new Evento();
		evento.setId(eventoId);
		eventoRepository.delete(evento);
	}

	@Override
	public List<Evento> listarEventosdeEquipo(Equipo equipo) {
		return this.eventoRepository.findByEquipo(equipo);
	}


}
