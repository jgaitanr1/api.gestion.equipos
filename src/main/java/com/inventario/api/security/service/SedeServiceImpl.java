package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Sede;
import com.inventario.api.repository.SedeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SedeServiceImpl implements SedeService{

	@Autowired
	private SedeRepository sedeRepository;
	
	@Override
	public Sede agregarSede(Sede sede) {
		return sedeRepository.save(sede);
	}

	@Override
	public Sede actualizarSede(Sede sede) {
		return sedeRepository.save(sede);
	}

	@Override
	public Set<Sede> obtenerSedes() {
		return new LinkedHashSet<>(sedeRepository.findAll());
	}

	@Override
	public Sede obtenerSede(Integer id) {
		return sedeRepository.findById(id).get();
	}

//	@Override
//	public Sede obtenerSedeCodigo(String codigo) {
//		return sedeRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarSede(Integer id) {
		Sede sede = new Sede();
		sede.setId(id);
		sedeRepository.delete(sede);
		
	}

}
