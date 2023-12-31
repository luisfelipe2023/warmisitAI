package com.proyecto.warmisitAI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.proyecto.warmisitAI.models.Tecnico;
import com.proyecto.warmisitAI.repository.TecnicoRepository;

@Service
public class TecnicoService {
		@Autowired
		public  TecnicoRepository tecnicoRepository;

	    public List<Tecnico> obtenerTodosLosTecnicos() {
	        return tecnicoRepository.findAll();
	    }

	    public Optional<Tecnico> obtenerTecnicoPorId(int id) {
	        return tecnicoRepository.findById(id);
	    }

	    public void guardarTecnico(Tecnico tecnico) {
	        tecnicoRepository.save(tecnico);
	    }

	    public void eliminarTecnico(int id) {
	        tecnicoRepository.deleteById(id);
	    }
	    
	    public  int cantidadTotalTecnicos() {
	    	return  tecnicoRepository.countBy();
	    }
	    
	    
	    
	   
	    
	   
	    
	   
	    
}
