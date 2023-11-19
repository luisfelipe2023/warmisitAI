package com.proyecto.warmisitAI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_Tecnico")
@AllArgsConstructor//GENERA CONSTRUCTOR USANDO TODOS LOS ATRIBUTOS
@NoArgsConstructor//GENERA CONSTRUCTOR VACIO
public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_tecnico;
	public String nombre;
	public String apellidos;
	public String dni;
	public String telefono;

	
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	public Estado estado;
	
}