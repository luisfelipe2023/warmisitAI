package com.proyecto.warmisitAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.warmisitAI.models.BitacoraIncidentes;
import com.proyecto.warmisitAI.repository.BitacoraIncidentesRepository;

@Service
public class BitacoraIncidentesService {
	
	  private final BitacoraIncidentesRepository bitacoraRepository;

	    @Autowired
	    public BitacoraIncidentesService(BitacoraIncidentesRepository bitacoraRepository) {
	        this.bitacoraRepository = bitacoraRepository;
	    }

	    public List<BitacoraIncidentes> listarTodo() {
	        return bitacoraRepository.findAll();
	    }

	    public void guardar(BitacoraIncidentes bitacoraIncidentes) {
	        bitacoraRepository.save(bitacoraIncidentes);
	    }
}
