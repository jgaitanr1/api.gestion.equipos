package com.inventario.api.payload.response;

import com.inventario.api.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	String token; 
	int id;
	String username;
	String email;
	String nombre;
	String apellido;
	String docIdentidad;
	boolean estado;
	Role role;
}
