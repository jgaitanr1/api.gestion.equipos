package com.inventario.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String responsable;
	
	String fecProgramada;
	String horEvento;
	
	String fecRegistro;
	String horAtencion;
	String horFin;
	
	String durAtencion;
	String durInoperativo;
	
	String actividad;
	String problema;
	String descripcion;
	String causa;
	String afectado;
	
	
	@ManyToOne
    Equipo equipo;
}
