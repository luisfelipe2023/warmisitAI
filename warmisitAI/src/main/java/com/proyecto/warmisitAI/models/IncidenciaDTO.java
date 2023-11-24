package com.proyecto.warmisitAI.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class IncidenciaDTO {
	public LocalDate fecha;
    public LocalTime hora;
    public String nombre;
    public String descripcion;
    public String tipoIncidencia;
    
    public IncidenciaDTO(LocalDate fecha, LocalTime hora, String nombre, String descripcion, String tipoIncidencia) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoIncidencia = tipoIncidencia;
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
	public String getTipoIncidencia() {
		return tipoIncidencia;
	}
	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

    
    
}
