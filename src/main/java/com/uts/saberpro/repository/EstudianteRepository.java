package com.uts.saberpro.repository;

import com.uts.saberpro.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    Estudiante findByDocumento(String documento);
    
    // Nuevo método para buscar por registro
    Estudiante findByRegistro(String registro);
}