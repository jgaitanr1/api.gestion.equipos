package com.inventario.api.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.inventario.api.security.jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authProvider;

	 public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
                 .allowedOrigins("*")
                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                 .allowedHeaders("*");
     }

	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	     return http
	         .csrf(csrf -> csrf.disable())
	         .cors(cors -> cors.configurationSource(request -> {
	             CorsConfiguration corsConfig = new CorsConfiguration();
	             corsConfig.setAllowedOrigins(List.of("*"));
	             corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	             corsConfig.setAllowedHeaders(List.of("*"));
	             return corsConfig;
	         }))
	         .authorizeHttpRequests(authRequest -> authRequest
	             .requestMatchers(HttpMethod.GET).permitAll()
	             .requestMatchers(HttpMethod.POST).permitAll()
	             .requestMatchers(HttpMethod.PUT).permitAll()
	             .requestMatchers(HttpMethod.DELETE).permitAll()
	             .requestMatchers(HttpMethod.OPTIONS).permitAll()
	             .requestMatchers("/api/auth/**").permitAll()
	             .anyRequest().authenticated())
	         .sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	         .authenticationProvider(authProvider)
	         .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	         .build();
	 }
}
