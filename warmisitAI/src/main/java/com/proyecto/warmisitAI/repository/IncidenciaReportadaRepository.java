package com.proyecto.warmisitAI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.warmisitAI.models.IncidenciaReportada;

@Repository
public interface IncidenciaReportadaRepository extends JpaRepository<IncidenciaReportada, Integer>{

    @Query(value = "SELECT * FROM tbl_Incidencia_Reportada WHERE id_tipo_incidencia IS NULL", nativeQuery = true)
    List<IncidenciaReportada> listaIncidenciaReportada();
    
    IncidenciaReportada findById(int id);
    
}