package com.proyecto.warmisitAI.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="tbl_Tipo_Incidencia_Reportado")
@NoArgsConstructor//ESTA ANOTACION SIRVE PARA GENERAR CONSTRUCTOR VACIO
@AllArgsConstructor//ESTA ANOTACION SIRVE PARA GENER CONSTRUCTOR USANDO LOS ATRIBUTOS
public class TipoIncidenciaReportada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idIncidencia;
	public String nombre;
	
	
	public int getIdIncidencia() {
		return idIncidencia;
	}
	public void setIdIncidencia(int idIncidencia) {
		this.idIncidencia = idIncidencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
