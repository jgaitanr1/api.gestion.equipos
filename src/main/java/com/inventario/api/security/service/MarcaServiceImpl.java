package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Marca;
import com.inventario.api.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	public Marca agregarMarca(Marca marca) {
		return marcaRepository.save(marca);
	}

	@Override
	public Marca actualizarMarca(Marca marca) {
		return marcaRepository.save(marca);
	}

	@Override
	public Set<Marca> obtenerMarcas() {
		return new LinkedHashSet<>(marcaRepository.findAll());
	}

	@Override
	public Marca obtenerMarca(Integer id) {
		return marcaRepository.findById(id).get();
	}

//	@Override
//	public Marca obtenerMarcaCodigo(String codigo) {
//		return marcaRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarMarca(Integer id) {
		Marca marca = new Marca();
		marca.setId(id);
		marcaRepository.delete(marca);
		
	}

}
