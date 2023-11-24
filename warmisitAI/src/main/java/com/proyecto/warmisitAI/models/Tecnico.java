package com.proyecto.warmisitAI.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tbl_Tecnico")
@AllArgsConstructor//GENERA CONSTRUCTOR USANDO TODOS LOS ATRIBUTOS
@NoArgsConstructor//GENERA CONSTRUCTOR VACIO
public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_tecnico;
	@ManyToOne
	@JoinColumn(name = "id")
	public User user;
	public String dni;
	public String telefono;
	
	
	
	public int getId_tecnico() {
		return id_tecnico;
	}
	public void setId_tecnico(int id_tecnico) {
		this.id_tecnico = id_tecnico;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
}
