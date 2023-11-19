package com.proyecto.warmisitAI.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//GENERA LOS METODOS GET Y SET
@Entity
@Table(name="tbl_Incidencia_Reportada")
@NoArgsConstructor//ESTA ANOTACION SIRVE PARA GENERAR CONSTRUCTOR VACIO
@AllArgsConstructor//ESTA ANOTACION SIRVE PARA GENER CONSTRUCTOR USANDO LOS ATRIBUTOS
public class IncidenciaReportada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public LocalDate fecha;
	public LocalTime hora;
	public String nombre;
	public String descripcion;
	
}
