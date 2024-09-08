package com.inventario.api.payload.request;

import com.inventario.api.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	int id;
	String username;
	String password;
	String nombre;
	String apellido;
	String docIdentidad;
	String email;
	String nroTelefono;
	Role role;
	boolean enabled;
}
