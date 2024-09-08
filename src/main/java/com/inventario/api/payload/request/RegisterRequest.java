package com.inventario.api.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	String username;
	String password;
	String nombre;
	String apellido;
	String docIdentidad;
	String email;
	String nroTelefono;
	boolean estado;
}
