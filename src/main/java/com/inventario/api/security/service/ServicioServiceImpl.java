package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Servicio;
import com.inventario.api.repository.ServicioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService{

	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public Servicio agregarServicio(Servicio servicio) {
		return servicioRepository.save(servicio);
	}

	@Override
	public Servicio actualizarServicio(Servicio servicio) {
		return servicioRepository.save(servicio);
	}

	@Override
	public Set<Servicio> obtenerServicios() {
		return new LinkedHashSet<>(servicioRepository.findAll());
	}

	@Override
	public Servicio obtenerServicio(Integer id) {
		return servicioRepository.findById(id).get();
	}

//	@Override
//	public Servicio obtenerServicioCodigo(String codigo) {
//		return servicioRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarServicio(Integer id) {
		Servicio servicio = new Servicio();
		servicio.setId(id);
		servicioRepository.delete(servicio);
		
	}

}
