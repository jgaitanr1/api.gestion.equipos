package com.inventario.api.security.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.api.models.User;
import com.inventario.api.payload.request.UserRequest;
import com.inventario.api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UserRepository usuarioRepository;
	
	@Override
	public User agregarUsuario(User user) {
		return usuarioRepository.save(user);
	}
	
	@Override
	public User actualizarUsuario(UserRequest userRequest) {
		User user= User.builder()
				.id(userRequest.getId())
				.username(userRequest.getUsername())
				.email(userRequest.getEmail())
				.password(userRequest.getPassword())
				.nombre(userRequest.getNombre())
				.apellido(userRequest.getApellido())
				.docIdentidad(userRequest.getDocIdentidad())
				.nroTelefono(userRequest.getNroTelefono())
				.estado(true)
				.role(userRequest.getRole())
				.build();
		return usuarioRepository.save(user);
	}
	
	@Override
	public Set<User> obtenerUsuarios() {
		return new LinkedHashSet<>(usuarioRepository.findAll());
	}

	@Override
	public User obtenerUsuario(Integer id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public User obtenerUsuarioDNI(String docIdentidad) {
		return usuarioRepository.findByDocIdentidad(docIdentidad).get();
	}

	@Override
	public void eliminarUsuario(Integer id) {
		User usr = new User();
        usr.setId(id);
        usuarioRepository.delete(usr);
	}

}
