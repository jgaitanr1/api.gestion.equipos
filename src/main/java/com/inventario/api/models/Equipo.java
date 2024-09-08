package com.inventario.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String tipo;
	String nivel;
	String estado;
	String modelo;
	String serie;
	
	
	@NotBlank
	@Size(max = 6)
	String codigo;

	String fec_fabricacion;
	
	String enlFabricante;
	String enlRecomendaciones;
	String enlImagenes;
	
	@ManyToOne
    Marca marca;
	
	@ManyToOne
    Clase_equipo clase_equipo;
	
	@ManyToOne
    Sede sede;
	
	@ManyToOne
    Proveedor proveedor;
	
	@ManyToOne
    Ubicacion_fisica ubicacion_fisica;
	
	@ManyToOne
    Area area;
	
	@ManyToOne
    Servicio servicio;
}
