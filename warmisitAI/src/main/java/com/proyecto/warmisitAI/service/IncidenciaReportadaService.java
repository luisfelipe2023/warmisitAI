package com.proyecto.warmisitAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.warmisitAI.models.IncidenciaReportada;
import com.proyecto.warmisitAI.repository.IncidenciaReportadaRepository;

@Service
public class IncidenciaReportadaService {
	
	@Autowired
	public IncidenciaReportadaRepository incidenciaReportadaRepository;
	
	public List<IncidenciaReportada>obtenerIncidenciasReportadas(){
		return incidenciaReportadaRepository.findAll();
		
	}

	
}
