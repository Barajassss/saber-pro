package com.uts.saberpro.service;

import com.uts.saberpro.model.Usuario;
import com.uts.saberpro.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("====================================");
        System.out.println("Intentando cargar usuario: " + username);
        
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("❌ Usuario NO encontrado: " + username);
                    return new UsernameNotFoundException("Usuario no encontrado: " + username);
                });

        System.out.println("✓ Usuario encontrado en BD:");
        System.out.println("  - Username: " + usuario.getUsername());
        System.out.println("  - Rol: " + usuario.getRol());
        System.out.println("  - Activo: " + usuario.isActivo());
        System.out.println("  - Password hash: " + usuario.getPassword());

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());
        System.out.println("  - Authority: " + authority.getAuthority());

        UserDetails userDetails = User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .authorities(Collections.singletonList(authority))
                .accountExpired(false)
                .accountLocked(!usuario.isActivo())
                .credentialsExpired(false)
                .disabled(!usuario.isActivo())
                .build();

        System.out.println("✓ UserDetails creado exitosamente");
        System.out.println("====================================");
        
        return userDetails;
    }
}