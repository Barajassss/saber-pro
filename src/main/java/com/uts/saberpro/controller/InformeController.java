package com.uts.saberpro.controller;

import com.uts.saberpro.service.BeneficioService;
import com.uts.saberpro.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InformeController {

    private final EstudianteService service;
    private final BeneficioService beneficioService;

    // Constructor único con ambos servicios
    public InformeController(EstudianteService service, BeneficioService beneficioService) {
        this.service = service;
        this.beneficioService = beneficioService;
    }

    @GetMapping("/informes/general")
    public String informeGeneral(Model model) {
        model.addAttribute("estudiantes", service.listarTodos());
        return "informes/general";
    }

    @GetMapping("/informes/detalle/{id}")
    public String informeDetalle(@PathVariable Long id, Model model) {
        model.addAttribute("e", service.buscarPorId(id));
        return "informes/detalle";
    }

    @GetMapping("/informes/beneficios")
    public String beneficios(Model model) {

        var lista = service.listarTodos();

        lista.forEach(e -> {
            e.setBeneficio(beneficioService.obtenerBeneficio(e));
        });

        model.addAttribute("estudiantes", lista);

        return "informes/beneficios";
    }
}