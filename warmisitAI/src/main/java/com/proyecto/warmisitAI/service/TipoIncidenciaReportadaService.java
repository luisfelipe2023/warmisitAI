package com.proyecto.warmisitAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;
import com.proyecto.warmisitAI.repository.TipoIncidenciaReportadaRepository;

@Service
public class TipoIncidenciaReportadaService {
	
	@Autowired
	public TipoIncidenciaReportadaRepository tipoIncidenciaReportada;
	
	public List<TipoIncidenciaReportada> obtenerTipoIncidenciaReportada(){
		return tipoIncidenciaReportada.findAll();
	}

}
