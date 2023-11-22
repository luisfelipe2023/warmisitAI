package com.proyecto.warmisitAI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;

@Repository
public interface TipoIncidenciaReportadaRepository extends JpaRepository<TipoIncidenciaReportada, Integer>{

	List<TipoIncidenciaReportada> findAll();
}
