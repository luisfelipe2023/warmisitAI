package com.proyecto.warmisitAI.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_incidencia")
	private TipoIncidenciaReportada tipoIncidencia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoIncidenciaReportada getTipoIncidencia() {
		return tipoIncidencia;
	}
	public void setTipoIncidencia(TipoIncidenciaReportada tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}
	
	
	
	
}
