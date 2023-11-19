package com.proyecto.warmisitAI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.warmisitAI.models.IncidenciaReportada;

@Repository
public interface IncidenciaReportadaRepository extends JpaRepository<IncidenciaReportada, Integer>{

}
