package com.proyecto.warmisitAI.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.warmisitAI.models.IncidenciaReportada;
import com.proyecto.warmisitAI.models.IncidenciaDTO;
import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;
import com.proyecto.warmisitAI.repository.TipoIncidenciaReportadaRepository;
import com.proyecto.warmisitAI.service.IncidenciaReportadaService;
import com.proyecto.warmisitAI.service.TipoIncidenciaReportadaService;

@Controller

public class IncidenciaReportadaController {
	
	
	@Autowired
	UserDetailsService userDetailsService;
	private final IncidenciaReportadaService incidenciaReportadaService;
	private final TipoIncidenciaReportadaService tipoIncidenciaReportadaService;

	
	
    @Autowired
    public IncidenciaReportadaController(IncidenciaReportadaService incidenciaReportadaService, TipoIncidenciaReportadaService tipoIncidenciaReportadaService) {
        this.incidenciaReportadaService = incidenciaReportadaService;
        this.tipoIncidenciaReportadaService = tipoIncidenciaReportadaService;
    }
    
    
    
	 @GetMapping("/listaIncidenciasReportadas")
	 public String mostrarListaIncidenciasReportadas(Model model, Principal principal) {
	        List<IncidenciaReportada> incidenciasReportadas = incidenciaReportadaService.obtenerIncidenciasReportadas();
	        model.addAttribute("incidenciasReportadas", incidenciasReportadas);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
	        return "lista-incidencias-reportadas";
	    }
	 
	 
	 
	 @GetMapping("/crearIncidenciaForm")
	 public String mostrarFormularioIncidencia(Model model, Principal principal) {
	      model.addAttribute("incidencia", new IncidenciaReportada());
	      UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	      model.addAttribute("user", userDetails);
	      return "crear-incidencia-form";
	  }

	 
	 
	 @PostMapping("/crearIncidencia")
	 public String crearIncidencia(@ModelAttribute IncidenciaReportada incidencia, @RequestParam(value = "redirect", defaultValue = "/menu") String redirect) {
	     incidenciaReportadaService.guardarIncidenciasReportadas(incidencia);
	     return "redirect:" + redirect;
	 }


	  
	  @GetMapping("/menu")
	    public String mostrarMenu() {
	        return "menu";
	    }
	  
	  
	  @GetMapping("/evaluarIncidencia")
	  public String mostrarFormularioEvaluarIncidencia(@RequestParam("id") int idIncidencia, Model model, Principal principal) {
	      List<TipoIncidenciaReportada> tiposIncidencia = tipoIncidenciaReportadaService.obtenerTipoIncidenciaReportada();
	      IncidenciaReportada incidencia = incidenciaReportadaService.obtenerIncidenciaPorId(idIncidencia);
	      model.addAttribute("tiposIncidencia", tiposIncidencia);
	      model.addAttribute("incidencia", incidencia);
	      UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		  model.addAttribute("user", userDetails);
	      return "evaluar-incidencia-reportada";
	  }


	    @PostMapping("/agregarTipoIncidencia")
	    public String agregarTipoIncidencia(@RequestParam("idIncidenciaReportada") int idIncidenciaReportada, 
	                                         @RequestParam("idTipoIncidencia") int idTipoIncidencia) {
	        incidenciaReportadaService.agregarTipoIncidencia(idIncidenciaReportada, idTipoIncidencia);
	        return "redirect:/listaIncidenciasEvaluadas";
	    }
	    
	    
	    @GetMapping("/listaIncidenciasEvaluadas")
	    public String mostrarListaIncidenciasEvaluadas(Model model, Principal principal) {
	        List<IncidenciaDTO> incidenciasEvaluadas = incidenciaReportadaService.obtenerIncidenciasEvaluadas();
	        model.addAttribute("incidenciasReportadas", incidenciasEvaluadas);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
	        return "lista-incidencias-evaluadas";
	    }

	    @GetMapping("/listadoDeIncidenciasEvaluadas")
	    public String mostrarListadoDeIncidenciasEvaluadas(Model model, Principal principal) {
	        List<IncidenciaDTO> incidenciasEvaluadas = incidenciaReportadaService.obtenerIncidenciasEvaluadas();
	        model.addAttribute("incidenciasReportadas", incidenciasEvaluadas);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
	        return "listaIncidenciasEvaluadas";
	    }
}



