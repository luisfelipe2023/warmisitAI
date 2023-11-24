package com.proyecto.warmisitAI.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.proyecto.warmisitAI.models.Tecnico;
import com.proyecto.warmisitAI.service.TecnicoService;



@Controller
public class TecnicoController {
	   private final TecnicoService tecnicoService;
	   @Autowired
		UserDetailsService userDetailsService;
	   
	    public TecnicoController(TecnicoService tecnicoService) {
	        this.tecnicoService = tecnicoService;
	    }

	    @GetMapping("/listaTecnicos")
	    public String mostrarListadoTecnicos(Model model, Principal principal) {
	        List<Tecnico> tecnicos = tecnicoService.obtenerTodosLosTecnicos();
	        long cantidadTecnicos = tecnicoService.cantidadTotalTecnicos();
	        int tecnicosDisponibles = tecnicoService.obtenerTecnicosDisponibles();
	        int tecnicosOcupados = tecnicoService.obtenerTecnicosOcupado();
	        	            
	        model.addAttribute("tecnicos", tecnicos);
	       
	        model.addAttribute("tecnicosDisponibles",tecnicosDisponibles);
	        model.addAttribute("tecnicosOcupados", tecnicosOcupados);
	        model.addAttribute("cantidadTecnicos",cantidadTecnicos);
	        
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
			
	        return "tecnicos-lista";	       
	    }
	    
	   @GetMapping("/listaDeTecnicos")
	   public String mostrarListaDeTecnicos(Model model, Principal principal) {
	        List<Tecnico> tecnicos = tecnicoService.obtenerTodosLosTecnicos();
	        long cantidadTecnicos = tecnicoService.cantidadTotalTecnicos();
	        int tecnicosDisponibles = tecnicoService.obtenerTecnicosDisponibles();
	        int tecnicosOcupados = tecnicoService.obtenerTecnicosOcupado();
	        	            
	        model.addAttribute("tecnicos", tecnicos);
	       
	        model.addAttribute("tecnicosDisponibles",tecnicosDisponibles);
	        model.addAttribute("tecnicosOcupados", tecnicosOcupados);
	        model.addAttribute("cantidadTecnicos",cantidadTecnicos);
	        
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
			
	        return "listaTecnicos";	       
	    }
	    

}
