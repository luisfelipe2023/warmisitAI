package com.proyecto.warmisitAI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.warmisitAI.models.IncidenciaReportada;
import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;
import com.proyecto.warmisitAI.repository.TipoIncidenciaReportadaRepository;
import com.proyecto.warmisitAI.service.IncidenciaReportadaService;
import com.proyecto.warmisitAI.service.TipoIncidenciaReportadaService;

@Controller

public class IncidenciaReportadaController {
	
	
	private final IncidenciaReportadaService incidenciaReportadaService;
	private final TipoIncidenciaReportadaService tipoIncidenciaReportadaService;

	
	
    @Autowired
    public IncidenciaReportadaController(IncidenciaReportadaService incidenciaReportadaService, TipoIncidenciaReportadaService tipoIncidenciaReportadaService) {
        this.incidenciaReportadaService = incidenciaReportadaService;
        this.tipoIncidenciaReportadaService = tipoIncidenciaReportadaService;
    }
    
    
    
	 @GetMapping("/listaIncidenciasReportadas")
	 public String mostrarListaIncidenciasReportadas(Model model) {
	        List<IncidenciaReportada> incidenciasReportadas = incidenciaReportadaService.obtenerIncidenciasReportadas();
	        model.addAttribute("incidenciasReportadas", incidenciasReportadas);
	        return "lista-incidencias-reportadas";
	    }
	 
	 
	 
	 @GetMapping("/crearIncidenciaForm")
	 public String mostrarFormularioIncidencia(Model model) {
	      model.addAttribute("incidencia", new IncidenciaReportada());
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
	  public String mostrarFormularioEvaluarIncidencia(@RequestParam("id") int idIncidencia, Model model) {
	      List<TipoIncidenciaReportada> tiposIncidencia = tipoIncidenciaReportadaService.obtenerTipoIncidenciaReportada();
	      IncidenciaReportada incidencia = incidenciaReportadaService.obtenerIncidenciaPorId(idIncidencia);
	      model.addAttribute("tiposIncidencia", tiposIncidencia);
	      model.addAttribute("incidencia", incidencia);
	      return "evaluar-incidencia-reportada";
	  }


	    @PostMapping("/agregarTipoIncidencia")
	    public String agregarTipoIncidencia(@RequestParam("idIncidenciaReportada") int idIncidenciaReportada, 
	                                         @RequestParam("idTipoIncidencia") int idTipoIncidencia) {
	        incidenciaReportadaService.agregarTipoIncidencia(idIncidenciaReportada, idTipoIncidencia);
	        return "redirect:/listaIncidenciasReportadas";
	    }}

