package com.uts.saberpro.controller;

import com.uts.saberpro.repository.EstudianteRepository;
import com.uts.saberpro.model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repository;

    public EstudianteController(EstudianteRepository repository) {
        this.repository = repository;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", repository.findAll());
        return "estudiantes/lista";
    }

    // FORMULARIO CREAR
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/form";
    }

    // GUARDAR (CREAR/EDITAR)
    @PostMapping
    public String guardar(Estudiante estudiante) {
        repository.save(estudiante);
        return "redirect:/estudiantes";
    }

    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Estudiante est = repository.findById(id).orElseThrow();
        model.addAttribute("estudiante", est);
        return "estudiantes/form";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/estudiantes";
    }
}
