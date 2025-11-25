package com.uts.saberpro.controller;

import com.uts.saberpro.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstudianteConsultaController {

    private final EstudianteService service;

    public EstudianteConsultaController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping("/estudiante")
    public String buscarForm() {
        return "estudiantes/buscar";
    }

    @PostMapping("/estudiante/resultado")
    public String resultado(@RequestParam String registro, Model model) {

        var est = service.buscarPorRegistro(registro);

        model.addAttribute("e", est);

        return "estudiantes/resultado";
    }
}