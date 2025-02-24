package com.inventario.api.security.service;

import java.util.Set;

import com.inventario.api.models.User;
import com.inventario.api.payload.request.UserRequest;

public interface UsuarioService {

	User agregarUsuario(User user);

	User actualizarUsuario(UserRequest userRequest);

    Set<User> obtenerUsuarios();

    User obtenerUsuario(Integer id);
    
    User obtenerUsuarioDNI(String docIdentidad);

    void eliminarUsuario(Integer id);
    
}
