package com.proyecto.warmisitAI.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="tbl_Tipo_Incidencia_Reportado")
@NoArgsConstructor
@AllArgsConstructor
public class TipoIncidenciaReportada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_incidencia")
    private int idTipoIncidencia;
    private String nombre;
	
	
	public int getIdTipoIncidencia() {
		return idTipoIncidencia;
	}
	public void setIdTipoIncidencia(int idTipoIncidencia) {
		this.idTipoIncidencia = idTipoIncidencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
