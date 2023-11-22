package com.proyecto.warmisitAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.warmisitAI.models.IncidenciaDTO;
import com.proyecto.warmisitAI.models.IncidenciaReportada;
import com.proyecto.warmisitAI.models.Tecnico;
import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;
import com.proyecto.warmisitAI.repository.IncidenciaReportadaRepository;

@Service
public class IncidenciaReportadaService {
	
	@Autowired
	public IncidenciaReportadaRepository incidenciaReportadaRepository;
	
	public List<IncidenciaReportada> obtenerIncidenciasReportadas(){
		return incidenciaReportadaRepository.listaIncidenciaReportada();	
	}
	
	public void guardarIncidenciasReportadas(IncidenciaReportada incidenciaReportada) {
        incidenciaReportadaRepository.save(incidenciaReportada);
    }
	
	
	@Transactional
    public IncidenciaReportada obtenerIncidenciaPorId(int id) {
        return incidenciaReportadaRepository.findById(id);
    }
	
	
	 @Transactional
	 public void agregarTipoIncidencia(int idIncidenciaReportada, int idTipoIncidencia) {
	        IncidenciaReportada incidencia = obtenerIncidenciaPorId(idIncidenciaReportada);
	        TipoIncidenciaReportada tipoIncidencia = new TipoIncidenciaReportada();
	        tipoIncidencia.setIdTipoIncidencia(idTipoIncidencia);

	        // Establecer el tipo de incidencia en la incidencia reportada
	        incidencia.setTipoIncidencia(tipoIncidencia);

	        // Guardar la incidencia actualizada
	        incidenciaReportadaRepository.save(incidencia);
	    }
	 
	 
	 
	 public List<IncidenciaDTO> obtenerIncidenciasEvaluadas() {
	        return incidenciaReportadaRepository.listaIncidenciaEvaluada();
	    }
}