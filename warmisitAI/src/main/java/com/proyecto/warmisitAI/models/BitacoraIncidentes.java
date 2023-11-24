package com.proyecto.warmisitAI.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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


@Entity
@Table(name="Bitacora")
@NoArgsConstructor
@AllArgsConstructor
public class BitacoraIncidentes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
	
    public Date fecha;   
	
    public String hora;
    public String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_incidencia")
    public TipoIncidenciaReportada tipoIncidencia;

    @ManyToOne
    @JoinColumn(name = "incidencia_id")
    public IncidenciaReportada incidencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
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

	public IncidenciaReportada getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(IncidenciaReportada incidencia) {
		this.incidencia = incidencia;
	}

   
}
