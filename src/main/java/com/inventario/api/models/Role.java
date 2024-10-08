package com.inventario.api.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    ING;

	@Override
	public String getAuthority() {
		return name();
	}  
}