package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Ubicacion_fisica;
import com.inventario.api.repository.Ubicacion_fisicaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Ubicacion_fisicaServiceImpl implements Ubicacion_fisicaService{

	@Autowired
	private Ubicacion_fisicaRepository ubicacion_fisicaRepository;
	
	@Override
	public Ubicacion_fisica agregarUbicacion_fisica(Ubicacion_fisica ubicacion_fisica) {
		return ubicacion_fisicaRepository.save(ubicacion_fisica);
	}

	@Override
	public Ubicacion_fisica actualizarUbicacion_fisica(Ubicacion_fisica ubicacion_fisica) {
		return ubicacion_fisicaRepository.save(ubicacion_fisica);
	}

	@Override
	public Set<Ubicacion_fisica> obtenerUbicacion_fisicas() {
		return new LinkedHashSet<>(ubicacion_fisicaRepository.findAll());
	}

	@Override
	public Ubicacion_fisica obtenerUbicacion_fisica(Integer id) {
		return ubicacion_fisicaRepository.findById(id).get();
	}

//	@Override
//	public Ubicacion_fisica obtenerUbicacion_fisicaCodigo(String codigo) {
//		return ubicacion_fisicaRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarUbicacion_fisica(Integer id) {
		Ubicacion_fisica ubicacion_fisica = new Ubicacion_fisica();
		ubicacion_fisica.setId(id);
		ubicacion_fisicaRepository.delete(ubicacion_fisica);
		
	}

}
