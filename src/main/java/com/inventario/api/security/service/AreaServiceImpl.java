package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Area;
import com.inventario.api.repository.AreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaRepository areaRepository;
	
	@Override
	public Area agregarArea(Area area) {
		return areaRepository.save(area);
	}

	@Override
	public Area actualizarArea(Area area) {
		return areaRepository.save(area);
	}

	@Override
	public Set<Area> obtenerAreas() {
		return new LinkedHashSet<>(areaRepository.findAll());
	}

	@Override
	public Area obtenerArea(Integer id) {
		return areaRepository.findById(id).get();
	}

//	@Override
//	public Area obtenerAreaCodigo(String codigo) {
//		return areaRepository.findByCodigo(codigo).get();
//	}

	@Override
	public void eliminarArea(Integer id) {
		Area area = new Area();
		area.setId(id);
		areaRepository.delete(area);
		
	}

}
