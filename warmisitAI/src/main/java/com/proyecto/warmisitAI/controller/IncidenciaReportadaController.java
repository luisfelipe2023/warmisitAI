package com.proyecto.warmisitAI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.warmisitAI.models.IncidenciaReportada;
import com.proyecto.warmisitAI.service.IncidenciaReportadaService;

@Controller

public class IncidenciaReportadaController {
	private final IncidenciaReportadaService incidenciaReportadaService;

    @Autowired
    public IncidenciaReportadaController(IncidenciaReportadaService incidenciaReportadaService) {
        this.incidenciaReportadaService = incidenciaReportadaService;
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
	  public String crearIncidencia(@ModelAttribute IncidenciaReportada incidencia) {
	      incidenciaReportadaService.guardarIncidenciasReportadas(incidencia);
	      return "redirect:/mostrarMenu";
	  }
	  
	  @GetMapping("/menu")
	    public String mostrarMenu() {
	        return "menu";
	    }
}
