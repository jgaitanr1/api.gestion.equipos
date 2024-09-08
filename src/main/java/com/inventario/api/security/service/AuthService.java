package com.inventario.api.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventario.api.models.Role;
import com.inventario.api.models.User;
import com.inventario.api.payload.request.LoginRequest;
import com.inventario.api.payload.request.RegisterRequest;
import com.inventario.api.payload.response.AuthResponse;
import com.inventario.api.repository.UserRepository;
import com.inventario.api.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;	
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        String token=jwtService.getToken(user);
        
        AuthResponse authResponse = AuthResponse.builder()
                .token(token)
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail()) 
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .docIdentidad(user.getDocIdentidad())
                .estado(user.isEstado())
                .role(user.getRole()) 
                .build();
        
        return authResponse;
        /*return AuthResponse.builder()
            .token(token)
            .build();*/

    }
    
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode( request.getPassword()))
            .email(request.getEmail())
            .nombre(request.getNombre())
            .apellido(request.getApellido())
            .docIdentidad(request.getDocIdentidad())
            .nroTelefono(request.getNroTelefono())
            .estado(request.isEstado())
            .role(Role.USER)
            .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }
}