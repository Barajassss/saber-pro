package com.uts.saberpro.config;

import com.uts.saberpro.model.Usuario;
import com.uts.saberpro.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        System.out.println("===========================================");
        System.out.println("INICIANDO CREACIÓN DE USUARIOS...");
        System.out.println("===========================================");
        
        try {
            // Verificar si ya existen usuarios
            long count = usuarioRepository.count();
            System.out.println("Usuarios existentes en la base de datos: " + count);
            
            if (count == 0) {
                System.out.println("No hay usuarios. Creando usuarios por defecto...");
                
                // Crear usuario COORDINADOR
                String passAdmin = passwordEncoder.encode("admin123");
                Usuario coordinador = new Usuario();
                coordinador.setUsername("admin");
                coordinador.setPassword(passAdmin);
                coordinador.setRol("COORDINADOR");
                coordinador.setActivo(true);
                usuarioRepository.save(coordinador);
                System.out.println("✓ Usuario COORDINADOR creado:");
                System.out.println("  - Username: admin");
                System.out.println("  - Password (plano): admin123");
                System.out.println("  - Password (hash): " + passAdmin);
                
                // Crear usuario ESTUDIANTE
                String passEstudiante = passwordEncoder.encode("estudiante123");
                Usuario estudiante = new Usuario();
                estudiante.setUsername("estudiante");
                estudiante.setPassword(passEstudiante);
                estudiante.setRol("ESTUDIANTE");
                estudiante.setActivo(true);
                usuarioRepository.save(estudiante);
                System.out.println("✓ Usuario ESTUDIANTE creado:");
                System.out.println("  - Username: estudiante");
                System.out.println("  - Password (plano): estudiante123");
                System.out.println("  - Password (hash): " + passEstudiante);
                
                // Verificar que se guardaron
                long newCount = usuarioRepository.count();
                System.out.println("Usuarios después de crear: " + newCount);
                
                System.out.println("===========================================");
                System.out.println("USUARIOS CREADOS EXITOSAMENTE");
                System.out.println("===========================================");
                System.out.println("COORDINADOR -> Usuario: admin | Password: admin123");
                System.out.println("ESTUDIANTE  -> Usuario: estudiante | Password: estudiante123");
                System.out.println("===========================================");
            } else {
                System.out.println("Los usuarios ya existen. No se crearán nuevos.");
                System.out.println("Si quieres recrearlos, borra la base de datos.");
                
                // Mostrar usuarios existentes
                var usuarios = usuarioRepository.findAll();
                System.out.println("Usuarios existentes:");
                for (Usuario u : usuarios) {
                    System.out.println("  - " + u.getUsername() + " (ROL: " + u.getRol() + ")");
                }
                System.out.println("===========================================");
            }
        } catch (Exception e) {
            System.err.println("===========================================");
            System.err.println("ERROR CRÍTICO al crear usuarios:");
            System.err.println("===========================================");
            e.printStackTrace();
            System.err.println("===========================================");
        }
    }
}