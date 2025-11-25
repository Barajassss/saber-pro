package com.uts.saberpro.controller;

import com.uts.saberpro.model.Usuario;
import com.uts.saberpro.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/crear-usuarios")
    public String crearUsuarios() {
        try {
            // Borrar usuarios existentes
            usuarioRepository.deleteAll();
            
            // Crear COORDINADOR
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol("COORDINADOR");
            admin.setActivo(true);
            usuarioRepository.save(admin);
            
            // Crear ESTUDIANTE
            Usuario estudiante = new Usuario();
            estudiante.setUsername("estudiante");
            estudiante.setPassword(passwordEncoder.encode("estudiante123"));
            estudiante.setRol("ESTUDIANTE");
            estudiante.setActivo(true);
            usuarioRepository.save(estudiante);
            
            return "<h1>Usuarios creados exitosamente</h1>" +
                   "<p>COORDINADOR: admin / admin123</p>" +
                   "<p>ESTUDIANTE: estudiante / estudiante123</p>" +
                   "<p><a href='/login'>Ir al login</a></p>" +
                   "<p><a href='/verificar-password'>Verificar passwords</a></p>";
        } catch (Exception e) {
            return "<h1>Error: " + e.getMessage() + "</h1>";
        }
    }
    
    @GetMapping("/verificar-password")
    public String verificarPassword(@RequestParam(defaultValue = "admin") String username,
                                     @RequestParam(defaultValue = "admin123") String password) {
        try {
            var usuario = usuarioRepository.findByUsername(username);
            
            if (usuario.isEmpty()) {
                return "<h1>Usuario no encontrado: " + username + "</h1>";
            }
            
            Usuario u = usuario.get();
            boolean matches = passwordEncoder.matches(password, u.getPassword());
            
            return "<h1>Verificación de Password</h1>" +
                   "<p><strong>Usuario:</strong> " + u.getUsername() + "</p>" +
                   "<p><strong>Password ingresado:</strong> " + password + "</p>" +
                   "<p><strong>Password hash en BD:</strong> " + u.getPassword() + "</p>" +
                   "<p><strong>¿Coincide?:</strong> " + (matches ? "✅ SÍ" : "❌ NO") + "</p>" +
                   "<hr>" +
                   "<p><a href='/verificar-password?username=admin&password=admin123'>Verificar admin</a></p>" +
                   "<p><a href='/verificar-password?username=estudiante&password=estudiante123'>Verificar estudiante</a></p>" +
                   "<p><a href='/login'>Ir al login</a></p>";
        } catch (Exception e) {
            return "<h1>Error: " + e.getMessage() + "</h1>" + 
                   "<pre>" + e.toString() + "</pre>";
        }
    }
}