package com.uts.saberpro.service;

import com.uts.saberpro.model.Estudiante;
import com.uts.saberpro.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    public Estudiante buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Estudiante buscarPorDocumento(String documento) {
        return repo.findByDocumento(documento);
    }
    
    // Nuevo método para buscar por registro
    public Estudiante buscarPorRegistro(String registro) {
        return repo.findByRegistro(registro);
    }
}