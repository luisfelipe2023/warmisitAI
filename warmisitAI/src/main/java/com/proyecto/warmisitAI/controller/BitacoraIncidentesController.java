package com.proyecto.warmisitAI.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.warmisitAI.models.BitacoraIncidentes;
import com.proyecto.warmisitAI.models.TipoIncidenciaReportada;
import com.proyecto.warmisitAI.service.BitacoraIncidentesService;
import com.proyecto.warmisitAI.service.TipoIncidenciaReportadaService;

@Controller
public class BitacoraIncidentesController {

    private final BitacoraIncidentesService bitacoraService;
    
  
    private final TipoIncidenciaReportadaService tipoIncidenciaService;
    

    @Autowired
    public BitacoraIncidentesController(BitacoraIncidentesService bitacoraService , TipoIncidenciaReportadaService tipoIncidenciaService) {
        this.bitacoraService = bitacoraService;
        this.tipoIncidenciaService = tipoIncidenciaService;
    }
    
    

    @GetMapping("/bitacora-listar")
    public String listarBitacora(Model model) {
        List<BitacoraIncidentes> bitacoraList = bitacoraService.listarTodo();
        model.addAttribute("bitacoraList", bitacoraList);
        return "bitacora-lista";
    }
   
   
}

