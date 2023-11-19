package com.proyecto.warmisitAI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyecto.warmisitAI.models.Estado;
import com.proyecto.warmisitAI.models.Tecnico;
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	 int countByEstado(Estado estado);//ESTE METODO REALIZA EL CONTEO DE TODOS LOS TECNICOS SEGUN SU ESTADO
	 int countBy();//ESTE METODO REALIZA EL CONTEO DE TODOS LOS TECNICOS
	
	 
}
